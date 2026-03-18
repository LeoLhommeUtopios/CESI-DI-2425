package org.example.Structural.Decorator;

public class PlainPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Pizza de base";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
