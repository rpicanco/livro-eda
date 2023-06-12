package com.ecommerce.abc.inventories.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class InventoryOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void pedidoReservado(OrderDto order) {
        enviarMensagem("pedidoReservado-out-0", order);
    }

    public void pedidoRecusado(OrderDto order) {
        enviarMensagem("pedidoRecusado-out-0", order);
    }

    private void enviarMensagem(String bindingName, OrderDto order) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(order));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
