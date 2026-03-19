package org.example.Behavioral.Observer;

public class MyObserver implements Observer{
    private String name;

    public MyObserver (String name){
        this.name=name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + "a recu un message : "+ message);
    }
}
