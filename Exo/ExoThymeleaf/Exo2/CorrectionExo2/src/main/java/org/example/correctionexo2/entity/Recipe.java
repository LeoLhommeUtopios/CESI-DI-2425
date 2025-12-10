package org.example.correctionexo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Recipe {
    @Id
    private UUID id;
    private String name;
    private String ingredients;
    private String Instructions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
