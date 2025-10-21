package org.example.Exo2;

public final class Arbre extends Plante{

    private float circonference;

    public Arbre(String nom, float hauteur, String couleur, String feuilles,float circonference) {
        super(nom, hauteur, couleur, feuilles);
        this.circonference = circonference;
    }

    public float getCirconference() {
        return circonference;
    }

    public void setCirconference(float circonference) {
        this.circonference = circonference;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("et la circonference du tronc est de : "+circonference+"  cm");
    }
}
