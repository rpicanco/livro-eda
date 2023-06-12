package com.ecommerce.abc.envios.client.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.dto.CustomerDto;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class DeliveryRequestDto {

    private String orderId;

    private CustomerDto customer;

}
