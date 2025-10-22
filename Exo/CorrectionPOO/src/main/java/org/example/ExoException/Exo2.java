package org.example.ExoException;

import java.util.Map;
import java.util.Scanner;

public class Exo2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int value;
        while (true){
            System.out.println("Entrer une valeur numerique :");
            String entry = sc.nextLine();
            try {
                value = Integer.parseInt(entry);
                if(value < 0 ) throw new RuntimeException("La valeur dois etre positive");
                System.out.println(Math.sqrt(value));
                break;
            }catch (NumberFormatException ex){
                System.out.println("Entrer une valeur numerique !");
            }catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }


    }
}
