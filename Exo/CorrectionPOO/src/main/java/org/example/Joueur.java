package org.example;

import javax.lang.model.element.NestingKind;

public class Joueur {

    private String nom;
    private int niveau;
    private long xp;


    public Joueur() {
    }

    public Joueur(String nom) {
        this.nom = nom;
    }

    public Joueur(String nom, int niveau, long xp) {
        this.nom = nom;
        this.niveau = niveau;
        this.xp = xp;
    }


    /**
     * Fonction pour la validation d'une quete d'un joueur
     *
     * @param xpGagnie xp offert par la completion de la quete
     *
     */
    public void validerQuete (long xpGagnie){
        xp += xpGagnie;
        if(xp >= 100){
            monterNiveau();
        }
        System.out.println("vous avez "+xp+" /100");
    }

    private void monterNiveau (){
        niveau ++;
        xp -= 100;
        System.out.println("Felicitation vous etes nv "+niveau);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", xp=" + xp +
                '}';
    }
}
