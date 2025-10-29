package org.example.entity.DemoBase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codeProduct;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

//    @ManyToMany(mappedBy = "orders")
//    private List<Product> products;

    @OneToMany(mappedBy = "orders")
    private List<OrdersProduct> ordersProducts;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", orderDate=" + orderDate +
                ", ordersProducts=" + ordersProducts +
                '}';
    }

}

