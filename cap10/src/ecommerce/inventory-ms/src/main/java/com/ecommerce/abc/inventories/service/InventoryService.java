package com.ecommerce.abc.inventories.service;

import com.ecommerce.abc.commons.dto.OrderDto;

public interface InventoryService {

    void processarCriacaoDePedido(OrderDto order);
}
