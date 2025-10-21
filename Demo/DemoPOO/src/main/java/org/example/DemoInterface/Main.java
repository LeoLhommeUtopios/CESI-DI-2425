package org.example.DemoInterface;

import org.example.DemoInterface.animaux.Animal;
import org.example.DemoInterface.animaux.mammiferes.Baleine;
import org.example.DemoInterface.animaux.mammiferes.Mammifere;
import org.example.DemoInterface.animaux.mammiferes.Ornithorynque;
import org.example.DemoInterface.animaux.oiseaux.Canard;
import org.example.DemoInterface.animaux.oiseaux.Pigeon;
import org.example.DemoInterface.animaux.poissons.PoissonVolant;
import org.example.DemoInterface.animaux.poissons.Thon;
import org.example.DemoInterface.interfaces.Nageant;
import org.example.DemoInterface.interfaces.Volant;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Baleine("La baleine","pas de fourure"),
                new Ornithorynque("Toto","marron"),
                new Canard("daffy","noir"),
                new Pigeon("tutu","blanc"),
                new Thon("Thon","bleu"),
                new PoissonVolant("vollant","verte")
        };

        for (Animal animal : animals){
            System.out.println(animal);

            if(animal instanceof Mammifere animalMamifere){
                animalMamifere.accoucher();
            }

            if(animal instanceof Nageant nageant){
                nageant.nager();
            }

            if(animal instanceof Volant volant){
                volant.decoller();
                volant.atterrir();
            }
        }

    }
}
