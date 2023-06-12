package com.ecommerce.abc.fulfillments.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.exception.BusinessException;
import com.ecommerce.abc.commons.exception.NotFoundException;
import com.ecommerce.abc.fulfillments.broker.FulfillmentOutput;
import com.ecommerce.abc.fulfillments.model.Fulfillment;
import com.ecommerce.abc.fulfillments.repository.FulfillmentRepository;
import com.ecommerce.abc.fulfillments.service.FulfillmentService;

import java.time.LocalDate;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class FulfillmentServiceImpl implements FulfillmentService {

    private final FulfillmentRepository repository;

    private final FulfillmentOutput output;

    @Override
    public void processarPagamentoAutorizado(OrderDto order) {
        repository.save(Fulfillment.builder()
                .orderId(order.getId())
                .originOrder(order)
                .build());
    }

    @Override
    public Fulfillment pack(String orderId, LocalDate packagedAt) {
        Fulfillment fulfillment = repository.findByOrderId(orderId)
                .orElseThrow(() -> new NotFoundException("Pedido [%s] não foi encontrado!", orderId));

        if (fulfillment.getPackagedAt() != null)
            throw new BusinessException("Pacote já foi embalado para o pedido [%s]", orderId);

        fulfillment.setPackagedAt(packagedAt);

        repository.save(fulfillment);
        output.pedidoEmbalado(fulfillment.getOriginOrder());
        log.info(format("[%s] Embalamento do pedido concluido", orderId));

        return fulfillment;
    }
}
