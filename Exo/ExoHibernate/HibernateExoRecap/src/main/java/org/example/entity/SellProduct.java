package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.product.Product;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sell_product")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sell")
    private Sell sell;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    private int quantity;

    @Override
    public String toString() {
        return "SellProduct{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
