package org.example.oauth2demoapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime orderDate;
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();


    public void addItem(Product product, Integer value) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(this);
        orderItem.setProduct(product);
        orderItem.setQuantity(value);
        items.add(orderItem);
    }

    public Double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice()*item.getQuantity())
                .sum();
    }
}
