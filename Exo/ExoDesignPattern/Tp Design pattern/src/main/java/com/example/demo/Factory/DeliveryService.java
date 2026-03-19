package com.example.demo.Factory;


import com.example.demo.Models.Order;

public interface DeliveryService {
    String getMode();
    int getDeliveryDays();
    double getCost();
    void ship(Order order);
}
