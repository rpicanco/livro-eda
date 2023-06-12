package com.ecommerce.abc.pagamentos.service.impl;

import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.dto.OrderPaymentRequestDto;
import com.ecommerce.abc.commons.dto.OrderPaymentResponseDto;
import com.ecommerce.abc.commons.enums.Currency;
import com.ecommerce.abc.commons.enums.PaymentTransactionStatus;
import com.ecommerce.abc.pagamentos.broker.PagamentoOutput;
import com.ecommerce.abc.pagamentos.client.PagamentoAclHttpClient;
import com.ecommerce.abc.pagamentos.model.OrderPaymentDetail;
import com.ecommerce.abc.pagamentos.model.Pagamento;
import com.ecommerce.abc.pagamentos.repository.PagamentoRepository;
import com.ecommerce.abc.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoOutput output;

    private final PagamentoRepository repository;

    private final PagamentoAclHttpClient httpClient;

    @Override
    public void processarPedidoConfirmado(OrderDto order) {
        OrderPaymentResponseDto response = httpClient.pagar(OrderPaymentRequestDto.builder()
                .orderId(order.getId())
                .cardId(order.getPayment().getCardId())
                .amount(order.getTotalAmount())
                .currency(Currency.BRL)
                .build());

        repository.save(Pagamento.builder()
                .id(response.getPaymentId())
                .orderId(order.getId())
                .cardId(order.getPayment().getCardId())
                .amount(order.getTotalAmount())
                .currency(Currency.BRL)
                .status(response.getStatus())
                .detail(converTo(response))
                .build());

        if (PaymentTransactionStatus.AUTHORIZED.equals(response.getStatus()))
            output.pagamentoAutorizado(order);
        else
            output.pagamentoNegado(order);

        log.info(format("[%s] Solicitação de pagamento concluida", order.getId()));
    }

    private static OrderPaymentDetail converTo(OrderPaymentResponseDto response) {
        if (response.getDetail() == null)
            return null;

        return OrderPaymentDetail.builder()
                .message(response.getDetail().getMessage())
                .description(response.getDetail().getDescription())
                .code(response.getDetail().getCode())
                .build();
    }
}
