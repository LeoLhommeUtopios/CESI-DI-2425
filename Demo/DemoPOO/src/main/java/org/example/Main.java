package org.example;


public class Main {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture();

        Voiture maVoiture2 = new Voiture("Clio","rouge",33.33,720);


        System.out.println(maVoiture);
        System.out.println(maVoiture2);

        maVoiture.afficher();
        maVoiture2.afficher();

        maVoiture2.demarer();
        maVoiture2.demarer();

    }
}