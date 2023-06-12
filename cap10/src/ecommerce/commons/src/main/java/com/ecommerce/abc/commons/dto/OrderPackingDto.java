package com.ecommerce.abc.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.constraints.NotNull;
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
public class OrderPackingDto {

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate packagedAt;
}
