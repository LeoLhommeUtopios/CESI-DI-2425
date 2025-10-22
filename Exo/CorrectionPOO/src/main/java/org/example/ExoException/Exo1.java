package org.example.ExoException;

import java.util.Scanner;

public class Exo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int value;
        while (true){
            System.out.println("Entrer une valeur numerique :");
            String entry = sc.nextLine();
            try {
                 value = Integer.parseInt(entry);
                System.out.println(value);
                break;
            }catch (NumberFormatException ex){
                System.out.println("Entrer une valeur numerique !");
            }
        }


    }
}
