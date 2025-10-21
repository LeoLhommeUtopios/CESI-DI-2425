package org.example.DemoInterface.animaux.poissons;

import org.example.DemoInterface.interfaces.Nageant;
import org.example.DemoInterface.interfaces.Volant;

public class PoissonVolant extends Poisson implements Nageant, Volant {
    public PoissonVolant(String nom, String couleurEcailles) {
        super(nom, couleurEcailles);
    }

    @Override
    public void nager() {
        System.out.println("le poisson volant nage");
    }

    @Override
    public void decoller() {
        System.out.println("le poisson volant decolle");
    }

    @Override
    public void atterrir() {
        System.out.println("le poisson volant atteri");
    }
}
