package com.ecommerce.abc.fulfillments.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.abc.commons.dto.FulfillmentDto;
import com.ecommerce.abc.commons.dto.OrderPackingDto;
import com.ecommerce.abc.fulfillments.mapper.FulfillmentMapper;
import com.ecommerce.abc.fulfillments.model.Fulfillment;
import com.ecommerce.abc.fulfillments.service.FulfillmentService;

@RestController
@RequestMapping("/fulfillments")
@RequiredArgsConstructor
@Slf4j
public class FulfillmentController {

    private final FulfillmentService service;

    private final FulfillmentMapper mapper;

    @PatchMapping(value = "/pedidos/{orderId}/packaging", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FulfillmentDto> findById(@PathVariable(name = "orderId") String orderId,
                                                   @Valid @RequestBody OrderPackingDto orderPackingDto) {
        Fulfillment fulfillment = service.pack(orderId, orderPackingDto.getPackagedAt());

        return ResponseEntity.ok(mapper.toDTO(fulfillment));
    }
}
