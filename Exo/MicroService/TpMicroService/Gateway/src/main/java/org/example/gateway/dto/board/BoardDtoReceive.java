package org.example.gateway.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDtoReceive {
    private String name;
    private int idUserOwner;
    private int maxMember;
}
