package org.example.demoform.Voiture.repository;

import org.example.demoform.Voiture.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {

//    @Query("select v from Voiture v where v.couleur = :couleur")
//    List<Voiture> findVoitureByCouleur(String couleur);

}
