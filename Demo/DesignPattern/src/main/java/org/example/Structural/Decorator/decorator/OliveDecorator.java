package org.example.Structural.Decorator.decorator;

import org.example.Structural.Decorator.Pizza;

public class OliveDecorator extends PizzaDecorator{

    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() +", avec des olives";
    }

    @Override
    public double getCost() {
        return super.getCost()+0.5;
    }
}
