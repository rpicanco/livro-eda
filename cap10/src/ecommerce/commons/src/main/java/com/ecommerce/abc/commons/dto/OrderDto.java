package com.ecommerce.abc.commons.dto;

import com.ecommerce.abc.commons.enums.OrderStatus;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderDto {

    private String id;

    private Double totalAmount;

    private OrderStatus status;

    @Singular
    private List<ItemDto> items;

    private CustomerDto customer;

    private PaymentDto payment;

    private LocalDateTime createdAt, updatedAt;

}
