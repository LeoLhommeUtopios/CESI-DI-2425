package org.example.gateway.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gateway.dto.user.UserDtoResponse;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDtoResponse {
    private int id;
    private String name;
    private UserDtoResponse UserOwner;
    private int maxMember;
    private List<UserDtoResponse> member;
}
