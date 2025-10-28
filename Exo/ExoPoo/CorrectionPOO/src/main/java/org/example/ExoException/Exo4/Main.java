package org.example.ExoException.Exo4;

import java.lang.classfile.instruction.StackInstruction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<3 ; i++ ){
            System.out.println("entrer l'age de l'etudiant n°"+ (i+1));
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println( "entrer le nom de l'etudiant n°"+(i+1));
            String name = sc.nextLine();
            try {
                students.add(new Student(name,age));
            }catch (InvalidAgeException ex){
                System.out.println(ex.getMessage());
                i--;
            }

        }
    }
}
