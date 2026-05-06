package org.example.gateway.controller;

import org.example.gateway.dto.task.TaskDtoReceive;
import org.example.gateway.dto.task.TaskDtoResponse;
import org.example.gateway.dto.user.UserDtoReceive;
import org.example.gateway.dto.user.UserDtoResponse;
import org.example.gateway.tools.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private RestClient<TaskDtoResponse> taskClient;
    private ObjectMapper om;

    public TaskController() {
        this.taskClient = new RestClient<>("http://localhost:8083/api/task");
        this.om= new ObjectMapper();
    }

    @PostMapping
    public ResponseEntity<TaskDtoResponse> create (@RequestBody TaskDtoReceive receive){
        return ResponseEntity.ok(taskClient.postRequest(om.writeValueAsString(receive), TaskDtoResponse.class));
    }

}
