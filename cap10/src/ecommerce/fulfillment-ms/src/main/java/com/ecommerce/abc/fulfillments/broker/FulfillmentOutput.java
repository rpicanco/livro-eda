package com.ecommerce.abc.fulfillments.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class FulfillmentOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void pedidoEmbalado(OrderDto order) {
        enviarMensagem("pedidoEmbalado-out-0", order);
    }

    private void enviarMensagem(String bindingName, OrderDto order) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(order));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
