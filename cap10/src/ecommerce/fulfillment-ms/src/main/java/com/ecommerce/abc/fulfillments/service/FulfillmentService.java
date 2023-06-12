package com.ecommerce.abc.fulfillments.service;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.fulfillments.model.Fulfillment;

import java.time.LocalDate;

public interface FulfillmentService {

    void processarPagamentoAutorizado(OrderDto order);

    Fulfillment pack(String orderId, LocalDate packagedAt);
}
