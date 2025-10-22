package org.example.DemoStream;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Personne> personnes = Arrays.asList(new Personne("toto",12,"12334456"),
                new Personne("titi",20,"3246790089"),
                new Personne("tutu",22,"3247856749"),
                new Personne("tata",55,"3246758689"),
                new Personne("toto",12,"12334456"),
                new Personne("titi",20,"3246790089"),
                new Personne("tutu",22,"3247856749"),
                new Personne("tata",55,"3246758689"));

        OptionalDouble moyenneAge =personnes.stream()
                .mapToInt(Personne::getAge)
                .average();

//        int sum = 0;
//        for (Personne personne : personnes){
//            sum += personne.getAge();
//            }
//        int average =  sum /(personnes.size());

        if(moyenneAge.isPresent()){
            System.out.println("Moyenne d'age : "+moyenneAge.getAsDouble()+" ans");
        }


        Map<String,Long> personnesByName = personnes.stream()
                .collect(Collectors.groupingBy(Personne::getName, Collectors.counting()));

        personnesByName.forEach((k,v)-> System.out.println(k + ": " + v));

        List<Personne> personnes20 = personnes.stream()
                .filter((personne -> personne.getAge()>20))
                .toList();

        personnes20.forEach(System.out::println);
    }
}
