package com.ecommerce.abc.pagamentos.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import com.ecommerce.abc.commons.dto.OrderPaymentRequestDto;
import com.ecommerce.abc.commons.dto.OrderPaymentResponseDto;

public interface PaymentGatewayHttpClient {

    @PostExchange("/pagamentos")
    OrderPaymentResponseDto pagar(@RequestBody OrderPaymentRequestDto orderPaymentRequest);
}
