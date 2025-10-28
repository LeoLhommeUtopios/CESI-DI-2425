package org.example.ExoException;

public class Exo3 {

    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};


        try{
            for(int i = 0 ; i <= tableau.length ; i++){
                System.out.println(tableau[i]);
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("l'element a l'index 5 n'est pas present dans se tableau");
        }

    }
}
