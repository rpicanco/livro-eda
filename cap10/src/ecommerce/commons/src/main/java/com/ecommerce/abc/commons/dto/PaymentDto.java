package com.ecommerce.abc.commons.dto;

import com.ecommerce.abc.commons.enums.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import com.ecommerce.abc.commons.enums.Brand;

@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class PaymentDto {

    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    @NotNull
    private String cardId;

    private String bin;

    @NotBlank
    private String numberToken;

    private String cardholderName;

    private String securityCode;

    private String expirationMonth;

    private String expirationYear;

    private Brand brand;
}
