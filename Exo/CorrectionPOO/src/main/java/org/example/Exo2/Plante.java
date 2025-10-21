package org.example.Exo2;

public sealed class Plante permits Arbre {

    protected String nom;
    protected float hauteur;
    protected String couleur;
    protected String feuilles;

    public Plante(String nom, float hauteur, String couleur, String feuilles) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
        this.feuilles = feuilles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getFeuilles() {
        return feuilles;
    }

    public void setFeuilles(String feuilles) {
        this.feuilles = feuilles;
    }

    public void showInfo (){
        System.out.println(nom+" fait "+hauteur+" cm , est de couleur "+couleur+" est a des feuilles : "+feuilles);
    }
}
