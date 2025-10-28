package org.example.Exo4.model;

public abstract class Animal {

    protected String nom;
    protected int age;

    public Animal(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void manger();
    public abstract void dormir();
    public abstract void faireDuBruit();

    @Override
    public String toString() {
        return  super.getClass().getSimpleName()+
                " nom='" + nom + '\'' +
                ", age='" + age + '\'';
    }
}
