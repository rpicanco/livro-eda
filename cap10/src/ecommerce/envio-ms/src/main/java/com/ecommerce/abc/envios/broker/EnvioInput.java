package com.ecommerce.abc.envios.broker;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.envios.service.EnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class EnvioInput {

    private final EnvioService service;

    @Bean
    public Consumer<OrderDto> pedidoEmbalado() {
        return service::processarPedidoEmbalado;
    }

    @Bean
    public Consumer<OrderDto> pedidoEnvioConfirmado() {
        return service::processarEnvioConfirmado;
    }

}
