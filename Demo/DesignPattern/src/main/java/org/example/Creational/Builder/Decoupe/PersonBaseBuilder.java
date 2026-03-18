package org.example.Creational.Builder.Decoupe;

public class PersonBaseBuilder implements PersonBuilder{
    private Person person = new Person();

    @Override
    public void setLastname(String lastname) {
        person.setLastname(lastname);
    }

    @Override
    public void setFirstname(String firstname) {
        person.setFirstname(firstname);
    }

    @Override
    public void setAge(int age) {
        person.setAge(age);
    }

    @Override
    public Person build() {
        return person;
    }
}
