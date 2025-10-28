package org.example.ExoException.Exo4;

public class Student {
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 0) throw new InvalidAgeException("l'age ne doit pas etre negatif ou null");
        this.age = age;
    }
}
