package com.ecommerce.abc.pedidos.service.impl;

import com.ecommerce.abc.commons.enums.OrderStatus;
import com.ecommerce.abc.commons.exception.NotFoundException;
import com.ecommerce.abc.pedidos.broker.OrderOutput;
import com.ecommerce.abc.pedidos.model.Order;
import com.ecommerce.abc.pedidos.model.Payment;
import com.ecommerce.abc.pedidos.repository.OrderRepository;
import com.ecommerce.abc.pedidos.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    private final OrderOutput output;

    @Override
    public Order create(Order order) {
        order.calcularValorTotal();
        repository.save(order);
        output.pedidoCriado(order);
        log.info(format("[%s] Pedido Criado", order.getId()));
        return order;
    }

    @Override
    public Order findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum pedido encontrado ‘%s’", id));
    }

    @Override
    public void processarReservaDePedido(String orderId) {
        Order order = repository.reserve(orderId);

        log.info(format("[%s] Pedido Reservado", orderId));

        if (order.isQualified())
            confirmar(orderId);
    }

    @Override
    public void processarQualificacaoDePedido(String orderId) {
        Order order = repository.qualify(orderId);

        log.info(format("[%s] Pedido Qualificado", orderId));

        if (order.isReserved())
            confirmar(orderId);
    }

    @Override
    public void processarRecusaDePedido(String orderId) {
        repository.update(orderId, OrderStatus.cancelado);
        log.info(format("[%s] Pedido Recusado", orderId));
    }

    @Override
    public void processarPagamentoAutorizado(String orderId, Payment payment) {
        repository.update(orderId, payment);
        repository.update(orderId, OrderStatus.em_preparacao);
        log.info(format("[%s] Pagamento Autorizado :)", orderId));
    }

    @Override
    public void processarPagamentoNaoAutorizado(String orderId, Payment payment) {
        repository.update(orderId, payment);
        repository.update(orderId, OrderStatus.cancelado);
        log.info(format("[%s] Pagamento Não Autorizado :(", orderId));
    }

    @Override
    public void processarEnvioDePedido(String orderId) {
        repository.update(orderId, OrderStatus.enviado);
        log.info(format("[%s] Pedido Enviado", orderId));
    }

    @Override
    public void processarEntregaDePedido(String orderId) {
        repository.update(orderId, OrderStatus.entregue);
        log.info(format("[%s] Pedido Entregue :)", orderId));
    }

    private void confirmar(String orderId) {
        Order order = repository.update(orderId, OrderStatus.confirmado);
        output.pedidoConfirmado(order);
        log.info(format("[%s] Pedido Confirmado", orderId));
    }
}
