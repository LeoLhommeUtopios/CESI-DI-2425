package org.example.board.repository;

import org.example.board.models.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board,Integer> {
}
