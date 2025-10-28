package org.example.Exo4.util;

import org.example.Exo4.model.Elephant;
import org.example.Exo4.model.Lion;
import org.example.Exo4.model.enclos.Enclos;
import org.example.Exo4.model.enclos.EnclosDesElephant;
import org.example.Exo4.model.enclos.EnclosDesLions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {

    private Scanner sc = new Scanner(System.in);
    private Enclos<Elephant> elephantEnclos = new EnclosDesElephant();
    private Enclos<Lion> lionEnclos = new EnclosDesLions();


    public void start (){

        while(true){
            menu();
            String entry = sc.nextLine();
            switch (entry){
                case "1" -> addLion();
                case "2" -> addElephant();
                case "3" -> showAnimals();
                default -> {
                    return;
                }
            }
        }
    }

    private void menu (){
        System.out.println("""
                1/Creation de lion
                2/Creation d'elephant
                3/visualiser les animaux d'un enclot
                """);
    }


    private void addLion(){
        System.out.println("nom du lion : ");
        String name = sc.nextLine();
        System.out.println("age du lion :");
        int age = sc.nextInt();
        sc.nextLine();

        lionEnclos.ajouterAnimal(new Lion(name,age));
    }

    private void addElephant() {
        System.out.println("nom du elephant : ");
        String name = sc.nextLine();
        System.out.println("age du elephant :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("poids de l'elephant");
        double poids = sc.nextDouble();
        sc.nextLine();

        elephantEnclos.ajouterAnimal(new Elephant(name, age, poids));
    }

    private void showAnimals(){
        System.out.println("""
                1/enclot des lions
                2/enclot des elephants
                """);

        String value = sc.nextLine();

        switch (value){
            case "1" -> lionEnclos.afficherAnimaux();
            case "2" -> elephantEnclos.afficherAnimaux();
        }
    }
}
