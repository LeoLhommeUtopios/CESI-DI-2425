package org.example.Creational.Builder.Decoupe;

public class Director {

    private PersonBuilder personBuilder;

    public Director(PersonBuilder personBuilder){
        this.personBuilder = personBuilder;
    }

    public void constructPerson(){
        personBuilder.setFirstname("toto");
        personBuilder.setLastname("tata");
        personBuilder.setAge(43);
    }
}
