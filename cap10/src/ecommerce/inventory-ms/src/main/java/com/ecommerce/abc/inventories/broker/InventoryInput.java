package com.ecommerce.abc.inventories.broker;

import com.ecommerce.abc.inventories.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class InventoryInput {

    private final InventoryService service;

    @Bean
    public Consumer<OrderDto> pedidoCriado() {
        return service::processarCriacaoDePedido;
    }

}
