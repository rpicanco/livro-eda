package com.ecommerce.abc.notificacoes.broker;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.notificacoes.service.NotificacaoAclService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class NotificacaoAclInput {

    private final NotificacaoAclService service;

    @Bean
    public Consumer<OrderDto> pedidoRecusado() {
        return service::processarPedidoRecusado;
    }

    @Bean
    public Consumer<OrderDto> pagamentoNegado() {
        return service::processarPagamentoNegado;
    }

    @Bean
    public Consumer<OrderDto> pedidoEnviado() {
        return service::processarPedidoEnviado;
    }

}
