package com.ecommerce.abc.commons.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderCreationDto {

    @Singular
    @Size(min = 1)
    @NotNull
    private List<@Valid ItemDto> items;

    @NotNull
    private CustomerDto customer;

    @NotNull
    private PaymentDto payment;
}
