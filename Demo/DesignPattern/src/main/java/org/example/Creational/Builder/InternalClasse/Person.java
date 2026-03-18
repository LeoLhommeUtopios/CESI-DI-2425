package org.example.Creational.Builder.InternalClasse;

public class Person {

    private String lastname;
    private String firstname;
    private int age;

    private Person (Builder builder){
        lastname = builder.lastname;
        firstname = builder.firstname;
        age = builder.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder{
        private String lastname;
        private String firstname;
        private int age;

        public Builder lastname (String lastname){
            this.lastname = lastname;
            return this;
        }

        public Builder firstname (String firstname){
            this.firstname = firstname;
            return this;
        }

        public Builder age (int age){
            this.age = age;
            return this;
        }

        public Person build(){return new Person(this);}
    }
}
