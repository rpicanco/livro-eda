package com.ecommerce.abc.commons.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderPaymentDetailDto {

    private String description;

    private String message;

    private String code;
}
