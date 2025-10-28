package org.example.Exo4.model;

public class Elephant extends Animal{
    private double poids;

    public Elephant(String nom, int age,double poids) {
        super(nom, age);
        this.poids = poids;
    }

    @Override
    public void manger() {
        System.out.println("l'elephant mange");
    }

    @Override
    public void dormir() {
        System.out.println("l'elephant dors");
    }

    @Override
    public void faireDuBruit() {
        System.out.println("l'elephant fait du bruit");
    }
}
