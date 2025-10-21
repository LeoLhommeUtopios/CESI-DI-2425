package org.example.demoHeritage;

public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal(12);
//        System.out.println(animal.getAge());
//
//        Canide canide = new Canide(13,"hector");
//        canide.crier();
//
//        Animal Canide_animal = new Canide(12,"Hector2");
//
//        Animal chien = new Chien(12,"chien1","chiuaua");
//
//        System.out.println( animal);
//        System.out.println( canide);
//        System.out.println( chien);


        Animal[] zoo = new Animal[5];
        zoo[0] = new Chien(12,"chien1","race1");
        zoo[1] = new Chien(12,"chien1","race1");
        zoo[2] = new Hyenne(12,"chien1");
        zoo[3] = new Hyenne(12,"chien1");
        zoo[4] = new Chien(12,"chien1","race1");

        for (int i = 0; i<zoo.length;i++){
            if( zoo[i] instanceof Chien chien ){
                chien.abboyer();
            }else{
                zoo[i].crier();
            }
        }
    }
}
