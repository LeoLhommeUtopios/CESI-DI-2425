package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Peripherique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String type;
    private String modele;
    private String typeConnexion;
    private boolean sansfil;
    private boolean entree;
    private boolean sortie;

    @ManyToMany(mappedBy = "peripheriques")
    private List<Ordinateur> ordinateurs;
}
