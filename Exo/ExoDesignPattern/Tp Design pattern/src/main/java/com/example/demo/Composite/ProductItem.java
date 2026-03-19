package com.example.demo.Composite;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductItem implements OrderComponent{
    private String name;
    private double unitPrice;
    private int quantity;

    @Override
    public double getPrice() {
        return unitPrice * quantity;
    }

    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s- %s (%.2f€ x%d) = %.2f€%n",
                indent, name, unitPrice, quantity, getPrice());
    }
}
