package org.example.entity.product;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder   
@Data
@ToString(callSuper = true)
public class ProductFood extends Product{
    
    private LocalDate dateExpiry;
}
