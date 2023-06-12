package com.ecommerce.abc.envios.service.impl;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.envios.client.DeliverySystemHttpClient;
import com.ecommerce.abc.envios.client.dto.DeliveryRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDeliveryDto;
import com.ecommerce.abc.envios.broker.EnvioAclOutput;
import com.ecommerce.abc.envios.service.EnvioAclService;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnvioAclServiceImpl implements EnvioAclService {

    private final EnvioAclOutput output;

    private final DeliverySystemHttpClient httpClient;

    @Override
    public void processarPedidoEnvioSolicitado(OrderDto order) {
        httpClient.requestOrderDelivery(DeliveryRequestDto.builder()
                .orderId(order.getId())
                .customer(order.getCustomer())
                .build());

        output.pedidoEnvioConfirmado(order);
    }

    @Override
    public void processarPedidoEntregue(OrderDeliveryDto delivery) {
        output.pedidoEntregue(delivery);
    }
}
