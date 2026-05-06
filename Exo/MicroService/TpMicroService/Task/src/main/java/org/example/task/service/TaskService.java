package org.example.task.service;

import org.example.task.dto.Board;
import org.example.task.dto.TaskDtoReceive;
import org.example.task.dto.TaskDtoResponse;
import org.example.task.dto.User;
import org.example.task.exception.NotFoundException;
import org.example.task.exception.TaskNotInProgressStateException;
import org.example.task.exception.UserIsNotActiveException;
import org.example.task.exception.UserIsNotInBoardException;
import org.example.task.models.Task;
import org.example.task.models.enums.Priority;
import org.example.task.models.enums.Status;
import org.example.task.repository.TaskRepository;
import org.example.task.tools.RestClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository repository;
    private RestClient<Board> boardRestClient;
    private RestClient<User> userRestClient;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
        this.boardRestClient = new RestClient<>("http://localhost:8082/api/board/");
        this.userRestClient = new RestClient<>("http://localhost:8081/api/user/");
    }

    public TaskDtoResponse createTask (TaskDtoReceive receive){
        return entityToDto(repository.save(dtoToEntity(receive)));
    }

    public TaskDtoResponse setUserToTask (int idTask,int idUser){
        Task task = repository.findById(idTask).orElseThrow(NotFoundException::new);
        if(task.getIdUser() == 0){
            User user = userRestClient.getRequest(User.class,"task/"+idUser);
            verificationUser(user,task);
            task.setIdUser(user.getId());
            task.setStatus(Status.IN_PROGRESS);
            repository.save(task);
            return entityToDto(task);

        }else{
            User user = userRestClient.getRequest(User.class,"task/"+idUser);
            verificationUser(user,task);
            userRestClient.getRequest(User.class,"taskRemove/"+task.getIdUser());
            task.setIdUser(user.getId());
            repository.save(task);
            return entityToDto(task);
        }
    }

    private void verificationUser (User user,Task task){
        if(user == null){
            throw new NotFoundException("User with id : "+task.getIdUser()+" not found");
        }
        Board board = boardRestClient.getRequest(Board.class,"id/"+task.getIdBoard());
        if(!user.getStatus().equals("ACTIVE")){
            userRestClient.getRequest(User.class,"taskRemove/"+user.getId());
            throw new UserIsNotActiveException();
        }
        if(!board.getMember().contains(User.builder().id(user.getId()).build())){
            userRestClient.getRequest(User.class,"taskRemove/"+user.getId());
            throw new UserIsNotInBoardException();
        }
    }

    public List<TaskDtoResponse> getTaskByUserId (int idUser){
        List<Task> tasks = repository.findTaskByIdUser(idUser);
        return tasks.stream().map(this::entityToDto).toList();
    }

    public TaskDtoResponse setTaskDone (int idTask){
        Task task = repository.findById(idTask).orElseThrow(NotFoundException::new);
        if(task.getStatus() == Status.IN_PROGRESS){
            User user = userRestClient.getRequest(User.class,"taskRemove/"+task.getIdUser());
            if(user != null){
                task.setStatus(Status.DONE);
                repository.save(task);
                return entityToDto(task);
            }
            throw new NotFoundException("User with id : "+task.getIdUser()+" not found");
        }
        throw new TaskNotInProgressStateException();

    }


    private Task dtoToEntity (TaskDtoReceive receive){
        Task task = Task.builder()
                .status(Status.TODO)
                .priority(Priority.valueOf(receive.getPriority()))
                .title(receive.getTitle())
                .description(receive.getDescription())
                .build();

        Board board = boardRestClient.getRequest(Board.class,"id/"+receive.getIdBoard());
        if(board != null){
            task.setIdBoard(receive.getIdBoard());
            return task;
        }
        System.out.println("board not found");
        throw new NotFoundException("board with id : "+receive.getIdBoard()+" not found");
    }

    private TaskDtoResponse entityToDto (Task task){
        TaskDtoResponse taskDtoResponse = TaskDtoResponse.builder()
                .id(task.getId())
                .status(task.getStatus().toString())
                .description(task.getDescription())
                .title(task.getTitle())
                .priority(task.getPriority().toString())
                .idBoard(task.getIdBoard())
                .build();

        if(task.getIdUser() != 0){
            User user = userRestClient.getRequest(User.class,task.getIdUser()+"");
            if(user != null){
               taskDtoResponse.setUser(user);
               return taskDtoResponse;
            }
            throw new NotFoundException("User with id : "+task.getIdUser()+" not found");
        }
        return taskDtoResponse;
    }


}
