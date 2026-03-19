package com.example.demo.Factory.delivery;

import com.example.demo.Factory.DeliveryService;
import com.example.demo.Models.Order;

public class PickupDelivery implements DeliveryService {
    @Override public String getMode()         { return "PICKUP"; }
    @Override public int    getDeliveryDays() { return 0; }
    @Override public double getCost()         { return 0.0; }

    @Override
    public void ship(Order order) {
        System.out.println("Retrait en point relais disponible pour la commande #" + order.getId());
    }
}