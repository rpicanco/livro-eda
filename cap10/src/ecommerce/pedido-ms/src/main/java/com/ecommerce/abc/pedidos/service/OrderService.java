package com.ecommerce.abc.pedidos.service;

import com.ecommerce.abc.pedidos.model.Order;
import com.ecommerce.abc.pedidos.model.Payment;

public interface OrderService {
    Order create(Order order);

    Order findById(String id);

    void processarReservaDePedido(String orderId);

    void processarQualificacaoDePedido(String orderId);

    void processarRecusaDePedido(String orderId);

    void processarPagamentoAutorizado(String orderId, Payment payment);

    void processarPagamentoNaoAutorizado(String orderId, Payment payment);

    void processarEnvioDePedido(String orderId);

    void processarEntregaDePedido(String orderId);
}
