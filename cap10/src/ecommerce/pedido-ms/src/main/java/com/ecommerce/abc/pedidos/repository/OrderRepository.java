package com.ecommerce.abc.pedidos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.pedidos.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>, CustomOrderRepository {
}
