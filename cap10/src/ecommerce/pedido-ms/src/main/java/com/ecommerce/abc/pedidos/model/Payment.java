package com.ecommerce.abc.pedidos.model;

import com.ecommerce.abc.commons.enums.Brand;
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
public class Payment {

    private String cardId, bin, numberToken, cardholderName, securityCode, expirationMonth, expirationYear;

    private Brand brand;
}
