package com.ecommerce.abc.envios.client.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.enums.DeliveryStatus;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class DeliveryResponseDto {

    private String id;

    private DeliveryStatus status;

}
