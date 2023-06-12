package com.ecommerce.abc.envios.broker;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnvioOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void pedidoEnvioSolicitado(OrderDto order) {
        enviarMensagem("pedidoEnvioSolicitado-out-0", order);
    }

    public void pedidoEnviado(OrderDto order) {
        enviarMensagem("pedidoEnviado-out-0", order);
    }

    private void enviarMensagem(String bindingName, OrderDto order) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(order));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
