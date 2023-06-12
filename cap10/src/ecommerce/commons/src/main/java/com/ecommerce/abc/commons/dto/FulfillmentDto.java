package com.ecommerce.abc.commons.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class FulfillmentDto {

    private String id;

    private String orderId;

    private LocalDate packagedAt;
}
