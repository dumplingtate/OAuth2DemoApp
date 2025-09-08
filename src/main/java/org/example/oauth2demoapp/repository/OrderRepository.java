package org.example.oauth2demoapp.repository;

import org.example.oauth2demoapp.entity.Order;
import org.example.oauth2demoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
    List<Order> findByStatus(String status);
}
