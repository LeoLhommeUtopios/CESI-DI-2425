package org.example.Creational.Builder.Decoupe;

public interface PersonBuilder {
    void setLastname (String lastname);
    void setFirstname(String firstname);
    void setAge (int age);
    Person build ();
}
