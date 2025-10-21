package org.example.DemoGenericite;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Boite<String,Integer,Long> box1 = new Boite<>();

        box1.setValue1("Bonjour");
        box1.setValue2(12345);
        box1.setValue3(123456789000000L);

        System.out.println(box1.getValue1() +" " + box1.getValue2() +" "+ box1.getValue3());

        Boite<String,String,String> box2 = new Boite<>();
        box2.setValue1("Bonjour");
        box2.setValue2("Bonjour");
        box2.setValue3("Bonjour");
    }



}
