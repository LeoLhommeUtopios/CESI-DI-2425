package com.example.demo.Factory;

import com.example.demo.Factory.delivery.ExpressDelivery;
import com.example.demo.Factory.delivery.PickupDelivery;
import com.example.demo.Factory.delivery.SameDayDelivery;
import com.example.demo.Factory.delivery.StandardDelivery;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class DeliveryFactory {

    public DeliveryService create(String mode) {
        return switch (mode.toUpperCase()) {
            case "STANDARD" -> new StandardDelivery();
            case "EXPRESS"  -> new ExpressDelivery();
            case "PICKUP"   -> new PickupDelivery();
            case "SAME_DAY" -> new SameDayDelivery();
            default -> throw new IllegalArgumentException(
                    "Mode de livraison inconnu : " + mode);
        };
    }

    public DeliveryService createCheapest(List<String> availableModes) {
        return availableModes.stream()
                .map(this::create)
                .min(Comparator.comparingDouble(DeliveryService::getCost))
                .orElseThrow(() -> new IllegalArgumentException("Aucun mode disponible"));
    }
}
