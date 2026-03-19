package com.example.demo.Observer;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderEventPublisher {

    // Spring injecte automatiquement TOUS les beans OrderObserver
    private final List<OrderObserver> observers;

    @Autowired
    public OrderEventPublisher(List<OrderObserver> observers) {
        this.observers = observers;
    }

    public void notifyStatusChange(Order order, OrderStatus newStatus) {
        observers.forEach(obs -> obs.onOrderStatusChanged(order, newStatus));
    }
}