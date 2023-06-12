package com.ecommerce.abc.envios.service;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.dto.OrderDeliveryDto;

public interface EnvioAclService {

    void processarPedidoEnvioSolicitado(OrderDto order);

    void processarPedidoEntregue(OrderDeliveryDto delivery);

}
