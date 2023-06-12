package com.ecommerce.abc.pedidos.broker;

import com.ecommerce.abc.commons.dto.OrderDeliveryDto;
import com.ecommerce.abc.commons.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.pedidos.mapper.OrderMapper;
import com.ecommerce.abc.pedidos.service.OrderService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class OrderInput {

    private final OrderService service;

    private final OrderMapper orderMapper;

    @Bean
    public Consumer<OrderDto> pedidoQualificado() {
        return order -> service.processarQualificacaoDePedido(order.getId());
    }

    @Bean
    public Consumer<OrderDto> pedidoReservado() {
        return order -> service.processarReservaDePedido(order.getId());
    }

    @Bean
    public Consumer<OrderDto> pedidoRecusado() {
        return order -> service.processarRecusaDePedido(order.getId());
    }

    @Bean
    public Consumer<OrderDto> pagamentoAutorizado() {
        return order -> service.processarPagamentoAutorizado(order.getId(), orderMapper.toPayment(order.getPayment()));
    }

    @Bean
    public Consumer<OrderDto> pagamentoNegado() {
        return order -> service.processarPagamentoNaoAutorizado(order.getId(), orderMapper.toPayment(order.getPayment()));
    }

    @Bean
    public Consumer<OrderDto> pedidoEnviado() {
        return order -> service.processarEnvioDePedido(order.getId());
    }

    @Bean
    public Consumer<OrderDeliveryDto> pedidoEntregue() {
        return order -> service.processarEntregaDePedido(order.getOrderId());
    }

}
