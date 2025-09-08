package org.example.oauth2demoapp.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.Order;
import org.example.oauth2demoapp.entity.Product;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.repository.OrderRepository;
import org.example.oauth2demoapp.repository.ProductRepository;
import org.example.oauth2demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(User user, Map<Long, Integer> products) {
        Order order = new Order();
        order.setUser(user);
        for(Map.Entry<Long, Integer> entry : products.entrySet()){
            Product product = productRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("product not found"));
            order.addItem(product, entry.getValue());
        }
        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUser(user);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
