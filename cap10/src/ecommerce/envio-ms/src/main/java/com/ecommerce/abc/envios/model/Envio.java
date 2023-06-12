package com.ecommerce.abc.envios.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("envio")
@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Envio {

    @Id
    private String orderId;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

    @Setter
    private LocalDate deliveryRequestedOn;
}
