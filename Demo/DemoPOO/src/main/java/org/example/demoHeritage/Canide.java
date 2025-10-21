package org.example.demoHeritage;

public abstract sealed class Canide extends Animal permits Chien, Hyenne{
    protected String nom;

    public Canide(int age,String nom) {
        super(age);
        this.nom = nom;
    }

    @Override
    public void crier() {
        System.out.println("Cri du canidé");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n nom='" + nom + '\'';
    }
}
