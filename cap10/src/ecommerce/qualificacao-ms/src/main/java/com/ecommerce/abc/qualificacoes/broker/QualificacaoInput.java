package com.ecommerce.abc.qualificacoes.broker;

import com.ecommerce.abc.qualificacoes.service.QualificacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.qualificacoes.service.QualificacaoService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class QualificacaoInput {

    private final QualificacaoService service;

    @Bean
    public Consumer<OrderDto> pedidoCriado() {
        return service::processarCriacaoDePedido;
    }

}
