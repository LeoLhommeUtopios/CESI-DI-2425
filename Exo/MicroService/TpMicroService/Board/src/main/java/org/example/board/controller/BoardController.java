package org.example.board.controller;

import org.example.board.dto.BoardDtoReceive;
import org.example.board.dto.BoardDtoResponse;
import org.example.board.exceptions.NotFoundException;
import org.example.board.models.Board;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BoardDtoResponse> addBoard (@RequestBody BoardDtoReceive receive){
        return ResponseEntity.ok(service.addBoard(receive));
    }

    @GetMapping("addmember/{idOwner}/{idUser}/{idBoard}")
    public ResponseEntity<BoardDtoResponse> addMember (@PathVariable int idOwner,@PathVariable int idUser,@PathVariable int idBoard){
        return ResponseEntity.ok(service.addMemberToBoard(idOwner,idUser,idBoard));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<BoardDtoResponse>> getBoardForUser (@PathVariable int idUser){
        return ResponseEntity.ok(service.getBoardFromUser(idUser));
    }

    @GetMapping("/id/{idBoard}")
    public ResponseEntity<BoardDtoResponse> getBoardById (@PathVariable int idBoard){
        return ResponseEntity.ok(service.getById(idBoard));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> NotFoundExceptionHandler (NotFoundException ex){
        return ResponseEntity.notFound().build();
    }
}
