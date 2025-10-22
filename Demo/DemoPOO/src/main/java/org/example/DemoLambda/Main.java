package org.example.DemoLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Pomme","Poire","Orange","Fraise");
        fruits.sort(String::compareTo);
        //.sort((f1,f2)-> f1.compareTo(f2))


        System.out.println("Liste triée :" +fruits );

        //Function
        Function<String,Integer> stringLengthFunction = str -> str.length();
//        Function<String,Integer> StringLengthFunction = String::length;


        stringLength((str) -> str.length() + 3);

        //consumer
        Consumer<String> printMessage = message -> System.out.println("Message : "+message);
        printMessage.accept("Ceci est un messsage !");

        //Predicate

        Predicate<Integer> isEven = number -> number%2 == 0;

        //Supplier
        Supplier<Integer> randomSupplier = ()-> new Random().nextInt(100);

        int testnbr = randomSupplier.get();
        if(isEven.test(testnbr)){
            System.out.println(testnbr+" est paire");
        }else{
            System.out.println(testnbr + " est impaire");
        }

    }

    public static void stringLength (Function<String,Integer> fctLength){
        String input = "Bonjour";
        int length = fctLength.apply(input);
        System.out.println("longueur de \"" + input + "\" : " +length);
    }
}
