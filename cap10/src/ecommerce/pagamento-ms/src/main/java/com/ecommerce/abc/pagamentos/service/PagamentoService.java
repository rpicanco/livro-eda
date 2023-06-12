package com.ecommerce.abc.pagamentos.service;

import com.ecommerce.abc.commons.dto.OrderDto;

public interface PagamentoService {

    void processarPedidoConfirmado(OrderDto order);
}
