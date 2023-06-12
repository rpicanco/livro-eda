package com.ecommerce.abc.notificacoes.service.impl;

import com.ecommerce.abc.notificacoes.service.TemplateEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.commons.exception.InternalServerErrorException;

import java.io.IOException;
import java.nio.charset.Charset;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateEmailServiceImpl implements TemplateEmailService {

    @Value("classpath:email-templates/payment-denied.txt")
    Resource paymentDeniedFile;

    @Value("classpath:email-templates/order-declined.txt")
    Resource orderDeclinedFile;

    @Value("classpath:email-templates/order-sent.txt")
    Resource orderSentFile;

    @Override
    public String getPaymentDeniedMessage(String orderId, String customerName) {
        return String.format(getMessage(paymentDeniedFile), customerName, orderId);
    }

    @Override
    public String getOrderDeclinedMessage(String orderId, String customerName, String reason) {
        return String.format(getMessage(orderDeclinedFile), customerName, orderId, reason);
    }

    @Override
    public String getOrderSentMessage(String orderId, String customerName) {
        return String.format(getMessage(orderSentFile), customerName, orderId);
    }

    private String getMessage(Resource resource) {
        try {
            return StringUtils.trimToEmpty(resource.getContentAsString(Charset.defaultCharset()));
        } catch (IOException e) {
            throw new InternalServerErrorException(e, "Falha na leitura do arquivo [%s]", resource.getFilename());
        }
    }
}
