package org.example.Structural.Decorator.decorator;

import org.example.Structural.Decorator.Pizza;

public class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", au Fromage";
    }

    @Override
    public double getCost() {
        return super.getCost()+1.50;
    }
}
