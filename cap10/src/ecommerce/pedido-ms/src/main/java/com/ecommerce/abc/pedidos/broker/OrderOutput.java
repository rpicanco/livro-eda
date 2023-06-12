package com.ecommerce.abc.pedidos.broker;

import com.ecommerce.abc.pedidos.mapper.OrderMapper;
import com.ecommerce.abc.pedidos.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    private final OrderMapper orderMapper;

    public void pedidoCriado(Order order) {
        enviarMensagem("pedidoCriado-out-0", order);
    }

    public void pedidoConfirmado(Order order) {
        enviarMensagem("pedidoConfirmado-out-0", order);
    }

    private void enviarMensagem(String bindingName, Order order) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(orderMapper.toDTO(order)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
