package com.ecommerce.abc.commons.dto;

import jakarta.validation.constraints.NotBlank;
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
public class AddressDto {

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String city;

    @NotBlank
    private String state;
}