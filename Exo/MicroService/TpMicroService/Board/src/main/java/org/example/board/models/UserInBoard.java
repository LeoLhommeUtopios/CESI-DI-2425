package org.example.board.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.board.controller.BoardController;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInBoard {
    @Id
    private int idUser;
    @ManyToMany(mappedBy = "members")
    private List<Board> boards;

    public UserInBoard(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserInBoard that = (UserInBoard) o;
        return idUser == that.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUser);
    }
}
