package com.ecommerce.abc.envios.broker;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDeliveryDto;

@Service
@RequiredArgsConstructor
public class EnvioAclOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void pedidoEnvioConfirmado(OrderDto order) {
        enviarMensagem("pedidoEnvioConfirmado-out-0", order);
    }

    public void pedidoEntregue(OrderDeliveryDto delivery) {
        enviarMensagem("pedidoEntregue-out-0", delivery);
    }

    private void enviarMensagem(String bindingName, Object object) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(object));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
