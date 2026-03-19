package com.example.demo.Observer;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FraudDetectionObserver implements OrderObserver {

    private static final double FRAUD_THRESHOLD = 1000.0;

    @Override
    public void onOrderStatusChanged(Order order, OrderStatus newStatus) {
        if (newStatus == OrderStatus.PAID
                && order.getTotalAmount() > FRAUD_THRESHOLD) {
            log.warn(" ALERTE FRAUDE — Commande #{} : montant {:.2f}€ dépasse {}€",
                    order.getId(), order.getTotalAmount(), FRAUD_THRESHOLD);
        }
    }
}