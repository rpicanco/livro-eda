package com.ecommerce.abc.inventories.service.impl;

import com.ecommerce.abc.inventories.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.inventories.broker.InventoryOutput;
import com.ecommerce.abc.inventories.exception.UnavailableItemsException;
import com.ecommerce.abc.inventories.model.Inventory;
import com.ecommerce.abc.inventories.service.InventoryService;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    private final InventoryOutput output;

    @Override
    public void processarCriacaoDePedido(OrderDto order) {
        try {
            order.getItems().forEach(item -> {
                Inventory inventory = repository
                        .findById(item.getProductId())
                        .orElseThrow(UnavailableItemsException::new);

                inventory.sell(item.getCount());
                repository.save(inventory);
            });
            output.pedidoReservado(order);
            log.info(format("[%s] Reserva do pedido concluida", order.getId()));
        } catch (UnavailableItemsException e) {
            output.pedidoRecusado(order);
            log.info(format("[%s] Reserva de pedido recusada", order.getId()));
        }
    }
}
