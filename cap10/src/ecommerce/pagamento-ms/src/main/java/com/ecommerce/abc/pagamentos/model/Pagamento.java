package com.ecommerce.abc.pagamentos.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.ecommerce.abc.commons.enums.Currency;
import com.ecommerce.abc.commons.enums.PaymentTransactionStatus;

@Document("payment")
@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Pagamento {

    @Id
    private String id;

    private String orderId;

    private String cardId;

    private Double amount;

    private Currency currency;

    private PaymentTransactionStatus status;

    private OrderPaymentDetail detail;
}
