package org.example.service;

import org.example.entity.Ordinateur;
import org.example.entity.Peripherique;
import org.example.entity.SystemeExploitation;
import org.example.repository.PeripheriqueRepository;
import org.example.repository.SystemeExploitationRepository;
import org.example.util.DatabaseManager;

import java.util.List;

public class PeripheriqueService {


    private final PeripheriqueRepository repository;

    public PeripheriqueService() {
        this.repository = new PeripheriqueRepository(DatabaseManager.getSessionFactory());
    }

    public Peripherique create (Peripherique peripherique){
        return repository.save(peripherique);
    }

    public List<Peripherique> get(){
        return repository.get();
    }

    public Peripherique get(long id){
        return repository.get(id, Peripherique.class);
    }

    public boolean remove (long id){
        Peripherique peripherique = get(id);
        if(peripherique != null){
            return repository.delete(peripherique);
        }
        return false;
    }

    public List<Ordinateur> getAllOrdinateurByPeripherique(long id_periph){
        Peripherique peripherique = get(id_periph);
        return peripherique.getOrdinateurs();
    }
}
