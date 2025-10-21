package org.example.demoHeritage;

public final class Chien extends Canide {

    private String race;

    public Chien(int age, String nom,String race) {
        super(age, nom);
        this.race = race;
    }

    @Override
    public void crier() {
        super.crier();
        System.out.println("le chien abboie !");
    }

    public void abboyer (){
        crier();
    }

    @Override
    public String toString() {
        return "Chien{" +
                "race='" + race + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}
