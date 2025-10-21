package org.example.DemoCollection;

import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //List
        List<String> words = new ArrayList<>();

        words.add("One");
        words.add("two");
        words.add("three");
        words.add("one");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");
        words.add("One");

//        for (String mot : words){
//            System.out.println(mot);
//        }


        //Set
        Set<String> setWords = new HashSet<>();

        setWords.add("One");
        setWords.add("two");
        setWords.add("two");
        setWords.add("two");
        setWords.add("two");
        setWords.add("two");
        setWords.add("three");
        setWords.add("three");
        setWords.add("three");
        setWords.add("three");
        setWords.add("One");
        setWords.add("One");
        setWords.add("One");
        setWords.add("One");
        setWords.add("One");

//        for (String mot : setWords){
//            System.out.println(mot);
//        }

        //treeSet
        SortedSet<String> fruits = new TreeSet<>();

        fruits.add("Banane");
        fruits.add("Pomme");
        fruits.add("Poire");
        fruits.add("Fraise");
        fruits.add("Ananas");
        fruits.add("Peche");

//        for (String fruit : fruits){
//            System.out.println(fruit);
//        }
//
//        System.out.println(fruits.first());
//        System.out.println(fruits.last());
//
//        SortedSet<String>  headset = fruits.headSet("Peche");
//        System.out.println(headset);

        //Map

        Map<String,Integer> panier = new HashMap<>();

        panier.put("Banane",4);
        panier.put("Viande Haché",3);
        panier.put("Eau",6);

        if(panier.containsKey("Banane")){
            panier.put("Banane",panier.get("Banane")+2);
        }else{
            panier.put("Banane",4);
        }

//        Set<Map.Entry<String,Integer>> hasset = panier.entrySet();
//
//        for(Map.Entry<String,Integer> entry : hasset){
//            System.out.println("key : "+ entry.getKey() + ", Value : "+ entry.getValue());
//        }

            for (Map.Entry<String,Integer> entry : panier.entrySet()){
                System.out.println("key : "+ entry.getKey() + ", Value : "+ entry.getValue());
            }


    }
}
