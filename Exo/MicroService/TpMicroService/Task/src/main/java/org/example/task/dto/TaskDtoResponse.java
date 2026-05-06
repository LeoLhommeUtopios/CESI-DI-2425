package org.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.task.models.enums.Priority;
import org.example.task.models.enums.Status;

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
    private User User;
    private int idBoard;
}
