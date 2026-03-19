package org.example.Creational.Singleton;

public class SingletonExample {

    private static SingletonExample instantce;

    private SingletonExample(){
        System.out.println("Singleton instancié !");
    }

    public static synchronized SingletonExample getInstance(){
        if(instantce == null){
            instantce = new SingletonExample();
        }
        return  instantce;
    }
}
