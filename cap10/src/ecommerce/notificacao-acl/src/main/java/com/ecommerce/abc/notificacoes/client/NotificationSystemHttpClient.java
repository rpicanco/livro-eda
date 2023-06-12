package com.ecommerce.abc.notificacoes.client;

import com.ecommerce.abc.notificacoes.client.dto.NotificationRequestDto;
import com.ecommerce.abc.notificacoes.client.dto.NotificationResponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface NotificationSystemHttpClient {

    @PostExchange("/notifications")
    NotificationResponseDto notify(@RequestBody NotificationRequestDto request);
}
