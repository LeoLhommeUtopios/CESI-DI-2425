package com.example.demo.Service;

import com.example.demo.Composite.OrderComponent;
import com.example.demo.Composite.ProductItem;
import com.example.demo.Decorateur.NotificationService;
import com.example.demo.Dto.CreateOrderRequest;
import com.example.demo.Factory.DeliveryFactory;
import com.example.demo.Factory.DeliveryService;
import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import com.example.demo.Observer.OrderEventPublisher;
import com.example.demo.Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository repository;
    private final DeliveryFactory deliveryFactory;
    private final OrderEventPublisher eventPublisher;
    private final NotificationService notificationService;

    public Order createOrder(CreateOrderRequest request) {
        // 1. Composite — calcul du total
        List<OrderComponent> components = request.getItems().stream()
                .map(i -> new ProductItem(i.getName(), i.getUnitPrice(), i.getQuantity()))
                .collect(toList());
        double total = components.stream()
                .mapToDouble(OrderComponent::getPrice).sum();

        // 2. Factory — sélection du service de livraison
        DeliveryService delivery = deliveryFactory.create(request.getDeliveryMode());

        // 3. Persistance
        Order order = new Order();
        order.setCustomerEmail(request.getEmail());
        order.setCustomerPhone(request.getPhone());
        order.setDeliveryMode(request.getDeliveryMode());
        order.setTotalAmount(total);
        order = repository.save(order);

        // 4. Décorateur — notification enrichie
        notificationService.send(
                request.getEmail(),
                "Commande #" + order.getId() + " confirmée",
                "Livraison via " + delivery.getMode() + " — Total : " + total + "€"
        );

        // 5. Observer — événements
        eventPublisher.notifyStatusChange(order, OrderStatus.PLACED);
        return order;
    }

    public Order updateStatus(Long id, OrderStatus newStatus) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande #" + id + " introuvable"));
        order.setStatus(newStatus);
        order = repository.save(order);

        notificationService.send(
                order.getCustomerEmail(),
                "Commande #" + id + " — statut mis à jour",
                "Nouveau statut : " + newStatus
        );
        eventPublisher.notifyStatusChange(order, newStatus);
        return order;
    }
}
