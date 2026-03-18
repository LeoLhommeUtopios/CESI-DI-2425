package org.example.Creational.Builder.InternalClasse;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder().age(23).lastname("toto").firstname("titi").build();
        Person person1 = new Person.Builder().age(12).build();
    }
}
