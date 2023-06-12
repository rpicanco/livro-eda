package com.ecommerce.abc.pedidos.model;

import com.ecommerce.abc.commons.enums.OrderStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document("order")
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Order {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private Double totalAmount;

    @Builder.Default
    private OrderStatus status = OrderStatus.recebido;

    @Singular
    private List<Item> items;

    private Customer customer;

    private Payment payment;

    private boolean qualified;

    private boolean reserved;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    public void calcularValorTotal() {
        totalAmount = items.stream()
                .mapToDouble(v -> v.getPrice() * v.getCount())
                .sum();
    }

}
