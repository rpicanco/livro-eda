package com.ecommerce.abc.pagamentos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.abc.commons.dto.OrderPaymentRequestDto;
import com.ecommerce.abc.commons.dto.OrderPaymentResponseDto;
import com.ecommerce.abc.pagamentos.service.PagamentoAclService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PagamentoAclController {

    private final PagamentoAclService service;

    @PostMapping(value = "/pagamento-acl/pagamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderPaymentResponseDto> pagar(@Valid @RequestBody OrderPaymentRequestDto orderPaymentRequest) {
        OrderPaymentResponseDto response = service.pagar(orderPaymentRequest);
        return ResponseEntity.ok(response);
    }
}
