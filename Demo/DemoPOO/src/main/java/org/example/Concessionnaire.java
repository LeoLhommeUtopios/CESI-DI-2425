package org.example;

public class Concessionnaire {
    private Voiture[] voitures;

    public Concessionnaire() {
        voitures = new Voiture[2];
    }

    public Voiture addvoiture (Voiture voiture) {
        voitures[0] = voiture;
        return voiture;
    }

    public Voiture addvoiture (String model, String couleur, double reservoir, long autonomie){
        Voiture voiture = new Voiture(model,couleur,reservoir,autonomie);
        voitures[1] = voiture;
        return voiture;
    }

    public Voiture[] getVoitures (){
        return voitures;
    }
}
