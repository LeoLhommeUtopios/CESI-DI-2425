package org.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
    private int id;
    private String name;
    private User UserOwner;
    private int maxMember;
    private List<User> member;
}
