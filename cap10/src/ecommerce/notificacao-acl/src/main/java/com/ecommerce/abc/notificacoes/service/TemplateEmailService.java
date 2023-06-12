package com.ecommerce.abc.notificacoes.service;

public interface TemplateEmailService {

    String getPaymentDeniedMessage(String orderId, String customerName);

    String getOrderDeclinedMessage(String orderId, String customerName, String reason);

    String getOrderSentMessage(String orderId, String customerName);
}
