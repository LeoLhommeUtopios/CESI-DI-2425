package com.example.demo.Factory.delivery;

import com.example.demo.Factory.DeliveryService;
import com.example.demo.Models.Order;

public class SameDayDelivery implements DeliveryService {
    @Override public String getMode()         { return "SAME_DAY"; }
    @Override public int    getDeliveryDays() { return 0; }
    @Override public double getCost()         { return 24.99; }

    @Override
    public void ship(Order order) {
        System.out.println("Livraison le jour même pour la commande #" + order.getId());
    }
}
