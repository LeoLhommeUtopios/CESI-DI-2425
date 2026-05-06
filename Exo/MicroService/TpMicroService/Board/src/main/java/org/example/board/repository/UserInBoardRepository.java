package org.example.board.repository;

import org.example.board.models.UserInBoard;
import org.springframework.data.repository.CrudRepository;

public interface UserInBoardRepository extends CrudRepository<UserInBoard,Integer> {
}
