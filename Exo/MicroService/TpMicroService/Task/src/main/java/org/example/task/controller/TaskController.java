package org.example.task.controller;

import org.example.task.dto.TaskDtoReceive;
import org.example.task.dto.TaskDtoResponse;
import org.example.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/inprogress/{iduser}/{idTask}")
    public ResponseEntity<TaskDtoResponse> setInProgress(@PathVariable int iduser,@PathVariable int idTask){
        return ResponseEntity.ok(service.setUserToTask(idTask,iduser));
    }
    @GetMapping("/done/{idTask}")
    public ResponseEntity<TaskDtoResponse> changeStatus(@PathVariable int idTask){
        return ResponseEntity.ok(service.setTaskDone(idTask));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<TaskDtoResponse>> getByUser (@PathVariable int idUser){
        return ResponseEntity.ok(service.getTaskByUserId(idUser));
    }

    @PostMapping
    public ResponseEntity<TaskDtoResponse> addUser (@RequestBody TaskDtoReceive dtoReceive){
        return ResponseEntity.ok(service.createTask(dtoReceive));
    }

}
