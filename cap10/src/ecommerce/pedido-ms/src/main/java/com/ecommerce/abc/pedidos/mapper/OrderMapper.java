package com.ecommerce.abc.pedidos.mapper;

import com.ecommerce.abc.commons.dto.OrderCreationDto;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.ecommerce.abc.pedidos.model.Order;
import com.ecommerce.abc.pedidos.model.Payment;

@Mapper
public interface OrderMapper {
    OrderDto toDTO(Order order);

    @Mappings({
            @Mapping(source = "items", target = "items"),
            @Mapping(source = "customer", target = "customer"),
            @Mapping(source = "payment", target = "payment")
    })
    Order toEntity(OrderCreationDto dto);

    Payment toPayment(PaymentDto dto);
}
