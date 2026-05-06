package org.example.gateway.controller;

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
@RequestMapping("/api/user")
public class UserController {

    private RestClient<UserDtoResponse> userClient;
    private ObjectMapper om;

    public UserController() {
        this.userClient = new RestClient<>("http://localhost:8081/api/user");
        this.om= new ObjectMapper();
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> create (@RequestBody UserDtoReceive receive){
        return ResponseEntity.ok(userClient.postRequest(om.writeValueAsString(receive), UserDtoResponse.class));
    }

}
