package com.ecommerce.abc.fulfillments.broker;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.fulfillments.service.FulfillmentService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class FulfillmentInput {

    private final FulfillmentService service;

    @Bean
    public Consumer<OrderDto> pagamentoAutorizado() {
        return service::processarPagamentoAutorizado;
    }

}
