package com.ecommerce.abc.fulfillments.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.ecommerce.abc.commons.dto.OrderDto;

import java.time.LocalDate;
import java.util.UUID;

@Document("fulfillment")
@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Fulfillment {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String orderId;

    @Setter
    private LocalDate packagedAt;

    private OrderDto originOrder;

}
