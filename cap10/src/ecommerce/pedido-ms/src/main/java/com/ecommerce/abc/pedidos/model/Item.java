package com.ecommerce.abc.pedidos.model;

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
public class Item {

    private String productId;
    private Integer count;
    private Double price;
}
