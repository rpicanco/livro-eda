package com.ecommerce.abc.inventories.model;

import com.ecommerce.abc.inventories.exception.UnavailableItemsException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("inventory")
@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Inventory {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private int items;

    public void sell(int items) {
        this.items = this.items - items;

        if (this.items < 0)
            throw new UnavailableItemsException();
    }
}
