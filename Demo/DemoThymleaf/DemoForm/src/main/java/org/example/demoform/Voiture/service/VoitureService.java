package org.example.demoform.Voiture.service;

import org.example.demoform.Voiture.entity.Voiture;
import org.example.demoform.Voiture.repository.VoitureRepository;
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
