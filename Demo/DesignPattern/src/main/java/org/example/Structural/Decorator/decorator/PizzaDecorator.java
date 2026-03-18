package org.example.Structural.Decorator.decorator;

import org.example.Structural.Decorator.Pizza;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription (){
        return pizza.getDescription();
    }

    @Override
    public double getCost(){
        return pizza.getCost();
    }

}
