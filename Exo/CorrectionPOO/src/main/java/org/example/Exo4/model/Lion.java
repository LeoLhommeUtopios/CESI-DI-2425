package org.example.Exo4.model;

public class Lion extends Animal{

    public Lion(String nom, int age) {
        super(nom, age);
    }

    @Override
    public void manger() {
        System.out.println("Le lion mange");
    }

    @Override
    public void dormir() {
        System.out.println("Le lion dors");
    }

    @Override
    public void faireDuBruit() {
        System.out.println("Le lion fait du bruit");
    }
}
