package org.example.Exo4.model.enclos;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclos<T> {

    protected List<T> listAnimaux;

    public Enclos() {
        listAnimaux = new ArrayList<>();
    }

    public void ajouterAnimal(T animal){
        listAnimaux.add(animal);
    }
    public void afficherAnimaux(){
        for( T animal : listAnimaux){
            System.out.println(animal);
        }
    }
}
