
package org.example.service;

import org.example.entity.Identification;
import org.example.entity.Ordinateur;
import org.example.entity.Peripherique;
import org.example.entity.SystemeExploitation;
import org.example.repository.OrdinateurRepository;
import org.example.repository.PeripheriqueRepository;
import org.example.repository.SystemeExploitationRepository;
import org.example.util.DatabaseManager;

import java.util.List;

public class OrdinateurService {

    private final OrdinateurRepository repository;
    private final SystemeExploitationRepository systemeExploitationRepository;
    private final PeripheriqueRepository peripheriqueRepository;

    public OrdinateurService() {
        repository = new OrdinateurRepository(DatabaseManager.getSessionFactory());
        systemeExploitationRepository =new SystemeExploitationRepository(DatabaseManager.getSessionFactory());
        peripheriqueRepository =new PeripheriqueRepository(DatabaseManager.getSessionFactory());
    }

    public Ordinateur create (String marque, String modele, double prix, boolean portable){
        return repository.save( Ordinateur.builder().marque(marque).modele(modele).prix(prix).portable(portable).build());
    }
    public Ordinateur create (String marque, String modele, double prix, boolean portable,String adresseMac,String  adressIP){
        return repository.save( Ordinateur.builder().marque(marque).modele(modele).prix(prix).portable(portable).identification(new Identification(adresseMac,adressIP)).build());
    }
    public Ordinateur create (Ordinateur ordinateur){
        return repository.save(ordinateur);
    }

    public List<Ordinateur> get(){
        return repository.get();
    }

    public Ordinateur get(long id){
        return repository.get(id, Ordinateur.class);
    }

    public boolean remove (long id){
        Ordinateur ordinateur = get(id);
        if(ordinateur != null){
            return repository.delete(ordinateur);
        }
        return false;
    }

    public Ordinateur setSystem (long idOrdinateur, long idSysteme){
        Ordinateur ordinateur = repository.get(idOrdinateur, Ordinateur.class);
        SystemeExploitation sys = systemeExploitationRepository.get(idSysteme, SystemeExploitation.class);
        ordinateur.setSystemeExploitation(sys);
        repository.save(ordinateur);
        return ordinateur;
    }

    public Ordinateur addPeripherique (long idOrdinateur, long idPeripherique){
        Ordinateur ordinateur = repository.get(idOrdinateur, Ordinateur.class);
        Peripherique peripherique = peripheriqueRepository.get(idPeripherique, Peripherique.class);
        ordinateur.addPeripherique(peripherique);
        repository.save(ordinateur);
        return ordinateur;
    }

    public List<Peripherique> getPeripheByOrdinateur (long id){
        Ordinateur ordinateur = repository.get(id, Ordinateur.class);
        return ordinateur.getPeripheriques();
    }


}
