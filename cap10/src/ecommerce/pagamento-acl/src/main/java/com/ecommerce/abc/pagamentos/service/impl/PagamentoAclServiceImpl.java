package com.ecommerce.abc.pagamentos.service.impl;

import com.ecommerce.abc.pagamentos.client.PaymentGatewayHttpClient;
import com.ecommerce.abc.pagamentos.service.PagamentoAclService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderPaymentRequestDto;
import com.ecommerce.abc.commons.dto.OrderPaymentResponseDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoAclServiceImpl implements PagamentoAclService {

    private final PaymentGatewayHttpClient httpClient;

    @Override
    public OrderPaymentResponseDto pagar(OrderPaymentRequestDto orderPaymentRequest) {
        return httpClient.pagar(orderPaymentRequest);
    }
}
