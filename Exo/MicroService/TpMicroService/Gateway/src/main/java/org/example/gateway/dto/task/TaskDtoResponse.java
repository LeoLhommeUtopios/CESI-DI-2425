package org.example.gateway.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gateway.dto.user.UserDtoResponse;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDtoResponse {
    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private UserDtoResponse User;
    private int idBoard;
}
