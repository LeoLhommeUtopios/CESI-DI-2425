package org.example.usermicservice.controller;

import org.example.usermicservice.dto.UserDtoReceive;
import org.example.usermicservice.dto.UserDtoResponse;
import org.example.usermicservice.exceptions.NotFoundException;
import org.example.usermicservice.exceptions.UserAlreadyHaveMaxTaskException;
import org.example.usermicservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAll(){
        return ResponseEntity.ok(service.getUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getAll(@PathVariable int id){
        return ResponseEntity.ok(service.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> addUser (@RequestBody UserDtoReceive dtoReceive){
        return ResponseEntity.ok(service.addUser(dtoReceive));
    }
    @GetMapping("/status/{id}")
    public ResponseEntity<UserDtoResponse> changeStatus(@PathVariable int id){
        return ResponseEntity.ok(service.changeStatus(id));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<UserDtoResponse> setTask (@PathVariable int id){
        return ResponseEntity.ok(service.addTask(id));
    }

    @GetMapping("/taskRemove/{id}")
    public ResponseEntity<UserDtoResponse> removeTask (@PathVariable int id){
        return ResponseEntity.ok(service.removeTask(id));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> NotFoundExceptionHandler (NotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UserAlreadyHaveMaxTaskException.class)
    public ResponseEntity<String> UserAlreadyHaveMaxTaskExceptionHandler (UserAlreadyHaveMaxTaskException ex){
        return ResponseEntity.badRequest().build();
    }

}
