package com.ecommerce.abc.commons.dto;

import com.ecommerce.abc.commons.enums.PaymentTransactionStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.enums.PaymentTransactionStatus;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderPaymentResponseDto {

    private String paymentId;

    private PaymentTransactionStatus status;

    private OrderPaymentDetailDto detail;
}
