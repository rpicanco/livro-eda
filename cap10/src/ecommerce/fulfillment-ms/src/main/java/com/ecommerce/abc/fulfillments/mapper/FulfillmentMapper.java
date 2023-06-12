package com.ecommerce.abc.fulfillments.mapper;

import org.mapstruct.Mapper;
import com.ecommerce.abc.commons.dto.FulfillmentDto;
import com.ecommerce.abc.fulfillments.model.Fulfillment;

@Mapper
public interface FulfillmentMapper {
    FulfillmentDto toDTO(Fulfillment fulfillment);
}
