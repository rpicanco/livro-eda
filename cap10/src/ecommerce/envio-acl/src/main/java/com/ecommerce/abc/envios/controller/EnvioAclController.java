package com.ecommerce.abc.envios.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.abc.commons.dto.OrderDeliveryDto;
import com.ecommerce.abc.envios.service.EnvioAclService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EnvioAclController {

    private final EnvioAclService service;

    @PostMapping(value = "/envio-acl/pedidos/entregues", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> receiveOrderDelivered(@Valid @RequestBody OrderDeliveryDto delivery) {
        service.processarPedidoEntregue(delivery);
        return ResponseEntity.noContent().build();
    }
}
