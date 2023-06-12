package com.ecommerce.abc.pedidos.repository;

import com.ecommerce.abc.commons.enums.OrderStatus;
import com.ecommerce.abc.pedidos.model.Order;
import com.ecommerce.abc.pedidos.model.Payment;

public interface CustomOrderRepository {

    Order update(String orderId, OrderStatus status);

    Order update(String orderId, Payment payment);

    Order reserve(String orderId);

    Order qualify(String orderId);
}
