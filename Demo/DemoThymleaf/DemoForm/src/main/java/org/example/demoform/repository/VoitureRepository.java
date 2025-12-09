package org.example.demoform.repository;

import org.example.demoform.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {

//    @Query("select v from Voiture v where v.couleur = :couleur")
//    List<Voiture> findVoitureByCouleur(String couleur);

}
