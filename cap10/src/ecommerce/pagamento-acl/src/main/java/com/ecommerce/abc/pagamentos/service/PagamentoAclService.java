package com.ecommerce.abc.pagamentos.service;

import com.ecommerce.abc.commons.dto.OrderPaymentRequestDto;
import com.ecommerce.abc.commons.dto.OrderPaymentResponseDto;

public interface PagamentoAclService {

    OrderPaymentResponseDto pagar(OrderPaymentRequestDto orderPaymentRequest);
}
