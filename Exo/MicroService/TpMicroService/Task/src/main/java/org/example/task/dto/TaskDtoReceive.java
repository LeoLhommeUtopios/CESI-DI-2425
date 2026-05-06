package org.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDtoReceive {
    private String title;
    private String description;
    private String priority;
    private int idBoard;
}
