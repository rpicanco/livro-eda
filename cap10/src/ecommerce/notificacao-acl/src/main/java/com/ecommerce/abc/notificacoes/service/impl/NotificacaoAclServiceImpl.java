package com.ecommerce.abc.notificacoes.service.impl;

import com.ecommerce.abc.notificacoes.client.NotificationSystemHttpClient;
import com.ecommerce.abc.notificacoes.client.dto.NotificationRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.notificacoes.service.NotificacaoAclService;
import com.ecommerce.abc.notificacoes.service.TemplateEmailService;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacaoAclServiceImpl implements NotificacaoAclService {

    private final NotificationSystemHttpClient httpClient;

    private final TemplateEmailService templateEmailService;

    @Override
    public void processarPedidoRecusado(OrderDto order) {
        String message = templateEmailService
                .getOrderDeclinedMessage(order.getId(), order.getCustomer().getFirstName(), "reason");

        httpClient.notify(NotificationRequestDto.builder()
                .email(order.getCustomer().getEmail())
                .message(message)
                .build());

        log.info(format("[%s] Notificação de pedido recusado", order.getId()));
    }

    @Override
    public void processarPagamentoNegado(OrderDto order) {
        String message = templateEmailService
                .getPaymentDeniedMessage(order.getId(), order.getCustomer().getFirstName());

        httpClient.notify(NotificationRequestDto.builder()
                .email(order.getCustomer().getEmail())
                .message(message)
                .build());

        log.info(format("[%s] Notificação de pagamento negado", order.getId()));
    }

    @Override
    public void processarPedidoEnviado(OrderDto order) {
        String message = templateEmailService
                .getOrderSentMessage(order.getId(), order.getCustomer().getFirstName());

        httpClient.notify(NotificationRequestDto.builder()
                .email(order.getCustomer().getEmail())
                .message(message)
                .build());

        log.info(format("[%s] Notificação de pedido enviado", order.getId()));
    }
}
