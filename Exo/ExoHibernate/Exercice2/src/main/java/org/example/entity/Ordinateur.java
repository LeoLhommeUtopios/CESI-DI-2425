package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ordinateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marque;
    private String modele;
    private  double prix;
    private boolean portable;

    @Embedded
    private Identification identification;

    @ManyToOne
    @JoinColumn(name = "id_os")
    private SystemeExploitation systemeExploitation;

    @ManyToMany
    @JoinTable(name = "Ordi_periph",
    joinColumns = @JoinColumn(name = "id_ordinateur"),
    inverseJoinColumns = @JoinColumn(name = "id_peripherique"))
    private List<Peripherique> peripheriques;

   public void addPeripherique(Peripherique peripherique){
       if(peripheriques == null) peripheriques = new ArrayList<>();
       peripheriques.add(peripherique);
   }
}
