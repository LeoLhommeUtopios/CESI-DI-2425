package com.example.demo.Repository;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerEmail(String email);

    List<Order> findByStatus(OrderStatus status);
}