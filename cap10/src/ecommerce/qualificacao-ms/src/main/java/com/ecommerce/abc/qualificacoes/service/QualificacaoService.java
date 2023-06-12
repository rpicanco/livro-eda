package com.ecommerce.abc.qualificacoes.service;

import com.ecommerce.abc.commons.dto.OrderDto;

public interface QualificacaoService {

    void processarCriacaoDePedido(OrderDto order);
}
