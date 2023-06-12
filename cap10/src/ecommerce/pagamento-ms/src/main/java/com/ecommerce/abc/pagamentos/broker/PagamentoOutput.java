package com.ecommerce.abc.pagamentos.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class PagamentoOutput {

    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void pagamentoNegado(OrderDto order) {
        enviarMensagem("pagamentoNegado-out-0", order);
    }

    public void pagamentoAutorizado(OrderDto order) {
        enviarMensagem("pagamentoAutorizado-out-0", order);
    }

    private void enviarMensagem(String bindingName, OrderDto order) {
        try {
            streamBridge.send(bindingName, objectMapper.writeValueAsBytes(order));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
