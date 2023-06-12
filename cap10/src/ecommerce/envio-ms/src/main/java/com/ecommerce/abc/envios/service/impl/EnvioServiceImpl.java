package com.ecommerce.abc.envios.service.impl;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.exception.NotFoundException;
import com.ecommerce.abc.envios.broker.EnvioOutput;
import com.ecommerce.abc.envios.model.Envio;
import com.ecommerce.abc.envios.repository.EnvioRepository;
import com.ecommerce.abc.envios.service.EnvioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnvioServiceImpl implements EnvioService {

    private final EnvioRepository repository;

    private final EnvioOutput output;

    @Override
    public void processarPedidoEmbalado(OrderDto order) {
        repository.save(Envio.builder()
                .orderId(order.getId())
                .build());

        output.pedidoEnvioSolicitado(order);
        log.info(format("[%s] Pedido de envio solicitado", order.getId()));
    }

    @Override
    public void processarEnvioConfirmado(OrderDto order) {
        Envio envio = repository.findById(order.getId())
                .orElseThrow(() -> new NotFoundException("Pedido [%s] não foi encontrado", order.getId()));

        envio.setDeliveryRequestedOn(LocalDate.now());

        repository.save(envio);

        output.pedidoEnviado(order);
        log.info(format("[%s] Pedido de envio confirmado", order.getId()));
    }
}
