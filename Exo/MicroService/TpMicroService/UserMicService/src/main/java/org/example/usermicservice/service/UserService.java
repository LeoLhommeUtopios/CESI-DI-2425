package org.example.usermicservice.service;

import org.example.usermicservice.dto.UserDtoReceive;
import org.example.usermicservice.dto.UserDtoResponse;
import org.example.usermicservice.exceptions.NotFoundException;
import org.example.usermicservice.exceptions.UserAlreadyHaveMaxTaskException;
import org.example.usermicservice.model.User;
import org.example.usermicservice.model.enums.Roles;
import org.example.usermicservice.model.enums.Status;
import org.example.usermicservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDtoResponse addUser (UserDtoReceive dtoReceive){
        return entityToDto(repository.save(dtoToEntity(dtoReceive)));
    }

    public UserDtoResponse getUser (int id){
        Optional<User> userfound = repository.findById(id);
        if(userfound.isPresent()){
            return entityToDto(userfound.get());
        }else{
            throw new NotFoundException("user at id : "+ id+ " not found");
        }
    }

    public List<UserDtoResponse> getUser (){
        List<User> userfounds = (List<User>) repository.findAll();
        return userfounds.stream().map(this::entityToDto).toList();
    }

    public UserDtoResponse changeStatus (int id){
        Optional<User> userfound = repository.findById(id);
        if(userfound.isPresent()){
            User user = userfound.get();
            user.setStatus(user.getStatus() == Status.ACTIVE ? Status.INACTIVE:Status.ACTIVE);
            repository.save(user);
            return entityToDto(user);
        }else{
            throw new NotFoundException("user at id : "+ id+ " not found");
        }
    }

    public UserDtoResponse addTask (int idUser){
        User user = repository.findById(idUser).orElseThrow(NotFoundException::new);
        System.out.println(user);
        if(user.getNumberOfTask() < 5){
            user.setNumberOfTask(user.getNumberOfTask()+1);
            repository.save(user);
            return entityToDto(user);
        }
        throw new UserAlreadyHaveMaxTaskException("User with id : "+idUser+" already have 5 Task");
    }

    public UserDtoResponse removeTask (int idUser){
        User user = repository.findById(idUser).orElseThrow(NotFoundException::new);
        if(user.getNumberOfTask() > 0){
            user.setNumberOfTask(user.getNumberOfTask()-1);
            repository.save(user);
            return entityToDto(user);
        }
        throw new UserAlreadyHaveMaxTaskException("User with id : "+idUser+" already have 5 Task");
    }

    private User dtoToEntity (UserDtoReceive userDtoReceive){
        return User.builder()
                .email(userDtoReceive.getEmail())
                .firstname(userDtoReceive.getFirstname())
                .lastname(userDtoReceive.getLastname())
                .password(userDtoReceive.getPassword())
                .numberOfTask(0)
                .role(Roles.MEMBER).status(Status.ACTIVE).build();
    }

    private UserDtoResponse entityToDto (User user){
        return UserDtoResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .role(user.getRole().toString()).status(user.getStatus().toString())
                .build();
    }
}
