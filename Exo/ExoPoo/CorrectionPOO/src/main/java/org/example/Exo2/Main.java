package org.example.Exo2;

public class Main {
    public static void main(String[] args) {

        Plante plante = new Plante("rose",12,"Rose","petale");

        Arbre arbre = new Arbre("Chene",300.3F,"blanc","feuilles",45);

        plante.showInfo();
        arbre.showInfo();
    }
}
