package com.ecommerce.abc.envios.service;

import com.ecommerce.abc.commons.dto.OrderDto;

public interface EnvioService {
    void processarPedidoEmbalado(OrderDto order);

    void processarEnvioConfirmado(OrderDto order);

}
