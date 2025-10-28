package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Animal {
    private int id;
    private String name;
    private String race;
    private String description;
    private String habitat;
    private int age;
}
