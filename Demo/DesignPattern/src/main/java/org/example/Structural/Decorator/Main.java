package org.example.Structural.Decorator;

import org.example.Structural.Decorator.decorator.CheeseDecorator;
import org.example.Structural.Decorator.decorator.OliveDecorator;

public class Main {
    public static void main(String[] args) {
        Pizza basepizza = new PlainPizza();
        System.out.println(basepizza.getDescription()+" "+basepizza.getCost());

        Pizza cheesePizza = new CheeseDecorator(basepizza);
        System.out.println(cheesePizza.getDescription() +" "+cheesePizza.getCost());
        Pizza doublecheesePizza = new CheeseDecorator(cheesePizza);
        System.out.println(doublecheesePizza.getDescription() +" "+doublecheesePizza.getCost());

        Pizza olivePizza = new OliveDecorator(doublecheesePizza);
        System.out.println(olivePizza.getDescription()+" "+olivePizza.getCost());

        Pizza basepizza2 = new PlainPizza();
        System.out.println(basepizza2.getDescription()+" "+basepizza2.getCost());

        Pizza olivePizza2 = new OliveDecorator(basepizza);
        System.out.println(olivePizza2.getDescription()+" "+olivePizza2.getCost());

        Pizza cheesePizza2 = new CheeseDecorator(cheesePizza);
        System.out.println(cheesePizza2.getDescription() +" "+cheesePizza2.getCost());






    }
}
