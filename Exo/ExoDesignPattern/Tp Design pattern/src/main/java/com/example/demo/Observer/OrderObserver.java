package com.example.demo.Observer;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;

public interface OrderObserver {
    void onOrderStatusChanged(Order order, OrderStatus newStatus);
}
