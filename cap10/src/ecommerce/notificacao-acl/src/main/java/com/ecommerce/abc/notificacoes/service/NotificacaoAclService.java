package com.ecommerce.abc.notificacoes.service;

import com.ecommerce.abc.commons.dto.OrderDeliveryDto;
import com.ecommerce.abc.commons.dto.OrderDto;

public interface NotificacaoAclService {

    void processarPedidoRecusado(OrderDto order);

    void processarPagamentoNegado(OrderDto order);

    void processarPedidoEnviado(OrderDto order);

}
