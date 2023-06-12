package com.ecommerce.abc.commons.dto;

import com.ecommerce.abc.commons.enums.Currency;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.enums.Currency;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderPaymentRequestDto {

    private String orderId;

    private String cardId;

    private Double amount;

    private Currency currency;
}
