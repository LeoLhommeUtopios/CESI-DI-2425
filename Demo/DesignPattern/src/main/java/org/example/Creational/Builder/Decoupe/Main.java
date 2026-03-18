package org.example.Creational.Builder.Decoupe;

public class Main {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBaseBuilder();
        Director director = new Director(builder);
        director.constructPerson();
        Person person = builder.build();
        System.out.println(person);

    }
}
