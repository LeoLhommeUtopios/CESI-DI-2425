package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Joueur jouer1 = new Joueur("toto");
        Joueur jouer2 = new Joueur("toto",5,55);

        jouer1.validerQuete(35);

        jouer2.validerQuete(55);

        System.out.println(jouer1);


    }
}