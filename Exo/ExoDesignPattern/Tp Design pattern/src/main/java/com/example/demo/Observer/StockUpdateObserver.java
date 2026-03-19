package com.example.demo.Observer;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StockUpdateObserver implements OrderObserver {

    @Override
    public void onOrderStatusChanged(Order order, OrderStatus newStatus) {
        if (newStatus == OrderStatus.PAID) {
            log.info("Mise à jour du stock pour la commande #{}", order.getId());
        }
    }
}