package com.ecommerce.abc.pedidos.controller;

import com.ecommerce.abc.commons.dto.OrderCreationDto;
import com.ecommerce.abc.commons.dto.OrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.abc.pedidos.mapper.OrderMapper;
import com.ecommerce.abc.pedidos.model.Order;
import com.ecommerce.abc.pedidos.service.OrderService;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;

    private final OrderMapper mapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> create(@Valid @RequestBody OrderCreationDto orderCreationDto) {
        Order order = service.create(mapper.toEntity(orderCreationDto));

        return ResponseEntity.accepted().body(mapper.toDTO(order));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> findById(@PathVariable(name = "id") String id) {
        Order order = service.findById(id);

        return ResponseEntity.ok(mapper.toDTO(order));
    }
}
