package com.example.demo.Factory.delivery;

import com.example.demo.Factory.DeliveryService;
import com.example.demo.Models.Order;


public class StandardDelivery implements DeliveryService {
    @Override public String getMode()         { return "STANDARD"; }
    @Override public int    getDeliveryDays() { return 5; }
    @Override public double getCost()         { return 4.99; }

    @Override
    public void ship(Order order) {
        System.out.println("Livraison standard (5 jours) pour la commande #" + order.getId());
    }
}