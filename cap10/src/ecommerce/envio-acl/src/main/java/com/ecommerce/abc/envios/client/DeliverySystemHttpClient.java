package com.ecommerce.abc.envios.client;

import com.ecommerce.abc.envios.client.dto.DeliveryRequestDto;
import com.ecommerce.abc.envios.client.dto.DeliveryResponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface DeliverySystemHttpClient {

    @PostExchange("/entregas")
    DeliveryResponseDto requestOrderDelivery(@RequestBody DeliveryRequestDto deliveryRequest);
}
