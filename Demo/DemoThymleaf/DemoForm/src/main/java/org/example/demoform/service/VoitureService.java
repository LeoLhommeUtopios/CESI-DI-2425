package org.example.demoform.service;

import lombok.RequiredArgsConstructor;
import org.example.demoform.entity.Voiture;
import org.example.demoform.repository.VoitureRepository;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class VoitureService {
//    @Autowired
    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public Voiture create (Voiture voiture){
        voitureRepository.save(voiture);
        return voiture;
    }

    public Voiture get (int id){
        return voitureRepository.getReferenceById(id);
    }

    public List<Voiture> get (){
        return voitureRepository.findAll();
    }
}
