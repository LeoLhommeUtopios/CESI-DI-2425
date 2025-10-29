package org.example.entity.DemoBase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float price;
    private String name;

//    @ManyToMany
//    @JoinTable(name = "product_orders",
//    joinColumns = @JoinColumn(name = "id_product"),
//    inverseJoinColumns = @JoinColumn(name = "id_orders"))
//    private List<Orders> orders;

    @OneToMany(mappedBy = "product")
    private List<OrdersProduct> orders;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
