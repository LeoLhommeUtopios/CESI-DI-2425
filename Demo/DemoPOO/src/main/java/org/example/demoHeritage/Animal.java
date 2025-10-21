package org.example.demoHeritage;

public abstract sealed class Animal permits Canide {

    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    public abstract void crier ();


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() +
                "\n age=" + age;
    }
}
