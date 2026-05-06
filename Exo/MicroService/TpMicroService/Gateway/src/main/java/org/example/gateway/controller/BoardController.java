package org.example.gateway.controller;

import org.example.gateway.dto.board.BoardDtoReceive;
import org.example.gateway.dto.board.BoardDtoResponse;
import org.example.gateway.dto.task.TaskDtoReceive;
import org.example.gateway.dto.task.TaskDtoResponse;
import org.example.gateway.tools.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private RestClient<BoardDtoResponse> boardClient;
    private ObjectMapper om;

    public BoardController() {
        this.boardClient = new RestClient<>("http://localhost:8081/api/board");
        this.om= new ObjectMapper();
    }

    @PostMapping
    public ResponseEntity<BoardDtoResponse> create (@RequestBody BoardDtoReceive receive){
        return ResponseEntity.ok(boardClient.postRequest(om.writeValueAsString(receive),  BoardDtoResponse.class));
    }

    @GetMapping("addmember/{idOwner}/{idUser}/{idBoard}")
    public ResponseEntity<BoardDtoResponse> addMember (@PathVariable int idOwner,@PathVariable int idUser,@PathVariable int idBoard){
        return ResponseEntity.ok(boardClient.getRequest(BoardDtoResponse.class,"/addmember/"+idOwner+"/"+idUser+"/"+idBoard));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<BoardDtoResponse>> getBoardForUser (@PathVariable int idUser){
        RestClient<BoardDtoResponse[]> listClient = new RestClient<>("http://localhost:8081/api/board");
        return ResponseEntity.ok(Arrays.stream(listClient.getRequest(BoardDtoResponse[].class ,"/"+idUser)).toList());
    }

    @GetMapping("/id/{idBoard}")
    public ResponseEntity<BoardDtoResponse> getBoardById (@PathVariable int idBoard){
        return ResponseEntity.ok(boardClient.getRequest(BoardDtoResponse.class,"/id/"+idBoard));
    }


}
