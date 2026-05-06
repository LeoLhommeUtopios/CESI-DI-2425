package org.example.board.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private int idUserOwner;
    private int maxMember;

    @ManyToMany
    @JoinTable(name = "board_user",
    joinColumns = @JoinColumn(name = "id_board"),
    inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserInBoard> members;

    public void addMenber(UserInBoard user){
        members.add(user);
    }
}
