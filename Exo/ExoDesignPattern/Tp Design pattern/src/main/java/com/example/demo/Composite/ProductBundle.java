package com.example.demo.Composite;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductBundle implements OrderComponent{
    private String name;
    private int quantity;
    private List<OrderComponent> children = new ArrayList<>();

    public ProductBundle(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void add(OrderComponent component) {
        children.add(component);
    }

    @Override
    public double getPrice() {
        return children.stream()
                .mapToDouble(OrderComponent::getPrice)
                .sum() * quantity;
    }

    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s[Bundle] %s (x%d) = %.2f€%n",
                indent, name, quantity, getPrice());
        children.forEach(c -> c.display(depth + 1));
    }
}
