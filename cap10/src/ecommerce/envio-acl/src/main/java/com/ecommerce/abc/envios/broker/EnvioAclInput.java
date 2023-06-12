package com.ecommerce.abc.envios.broker;

import com.ecommerce.abc.commons.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.envios.service.EnvioAclService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class EnvioAclInput {

    private final EnvioAclService service;

    @Bean
    public Consumer<OrderDto> pedidoEnvioSolicitado() {
        return service::processarPedidoEnvioSolicitado;
    }

}
