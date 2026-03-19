package com.example.demo.Factory.delivery;

import com.example.demo.Factory.DeliveryService;
import com.example.demo.Models.Order;

public class ExpressDelivery implements DeliveryService {
    @Override public String getMode()         { return "EXPRESS"; }
    @Override public int    getDeliveryDays() { return 1; }
    @Override public double getCost()         { return 14.99; }

    @Override
    public void ship(Order order) {
        System.out.println("Livraison express (24h) pour la commande #" + order.getId());
    }
}