package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_orders")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Override
    public String toString() {
        return "OrdersProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
