package org.example.demo1;


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


        Voiture.getNbrVoiture();

        Concessionnaire concessionnaire = new Concessionnaire();
        concessionnaire.addvoiture(maVoiture2);
        concessionnaire.addvoiture("Clio","rouge",33.33,720);
        Voiture[] voitures = concessionnaire.getVoitures();
        for (int i = 0; i<voitures.length; i++){
            System.out.println(voitures[i]);
        }


        System.out.println(Calculatrice.addition(2,6));
        System.out.println(Calculatrice.addition("4","8"));

    }
}