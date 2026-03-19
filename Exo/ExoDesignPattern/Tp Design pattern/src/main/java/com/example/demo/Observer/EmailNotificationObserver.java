package com.example.demo.Observer;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailNotificationObserver implements OrderObserver {

    @Override
    public void onOrderStatusChanged(Order order, OrderStatus newStatus) {
        log.info("Email envoyé à {} — Commande #{} : statut {}",
                order.getCustomerEmail(), order.getId(), newStatus);
    }
}