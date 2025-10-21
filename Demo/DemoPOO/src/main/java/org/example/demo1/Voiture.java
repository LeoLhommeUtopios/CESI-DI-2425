package org.example.demo1;

public class Voiture {

    private String model;
    private String couleur;
    private double reservoir;
    private long autonomie;

    private boolean demaree=false;

    private static int nbrVoiture;

    public Voiture() {
        nbrVoiture++;
    }

    public Voiture(String model, String couleur) {
        this();
        this.model = model;
        this.couleur = couleur;

    }

    public Voiture(String model, String couleur, double reservoir, long autonomie) {
        this(couleur,model);
        this.reservoir = reservoir;
        this.autonomie = autonomie;
    }

    public String getModel (){
        return this.model;
   }

   public void setModel (String model){
        if(!model.isBlank()){
            this.model = model;
        }
   }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getReservoir() {
        return reservoir;
    }

    public void setReservoir(double reservoir) {
        this.reservoir = reservoir;
    }

    public long getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(long autonomie) {
        this.autonomie = autonomie;
    }

    public boolean isDemaree() {
        return demaree;
    }

    public void setDemaree(boolean demaree) {
        this.demaree = demaree;
    }

    public void afficher (){
        System.out.println("Notre première voiture est une " + this.model + " de couleur " + this.couleur);
        System.out.println("Elle a un réservoir de " + this.reservoir
                + " litres pour une autonomie de " + this.autonomie + " km.");
    }

    public void demarer (){
        if(!demaree){
            System.out.println("la voiture demare !");
            demaree = true;
        }else {
            System.out.println("la voiture est deja demarée");
        }

    }

    public static void getNbrVoiture (){
        System.out.println("le nombre total de voiture est de : "+nbrVoiture);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "model='" + model + '\'' +
                ", couleur='" + couleur + '\'' +
                ", reservoir=" + reservoir +
                ", autonomie=" + autonomie +
                ", demaree=" + demaree +
                '}';
    }
}
