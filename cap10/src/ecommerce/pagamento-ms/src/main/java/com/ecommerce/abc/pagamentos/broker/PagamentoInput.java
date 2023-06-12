package com.ecommerce.abc.pagamentos.broker;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.pagamentos.service.PagamentoService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class PagamentoInput {

    private final PagamentoService service;

    @Bean
    public Consumer<OrderDto> pedidoConfirmado() {
        return service::processarPedidoConfirmado;
    }

}
