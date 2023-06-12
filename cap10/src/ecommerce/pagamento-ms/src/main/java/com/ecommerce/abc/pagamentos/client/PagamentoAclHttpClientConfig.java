package com.ecommerce.abc.pagamentos.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import com.ecommerce.abc.commons.exception.NotFoundException;
import com.ecommerce.abc.commons.exception.Projeto1Exception;

@Configuration
public class PagamentoAclHttpClientConfig {

    @Value("${pagamento-acl.url}")
    private String url;

    @Bean
    public PagamentoAclHttpClient createClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultStatusHandler(
                        httpStatusCode -> HttpStatus.NOT_FOUND == httpStatusCode,
                        response -> Mono.error(new NotFoundException("Conteúdo não encontrado!!")))
                .defaultStatusHandler(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new Projeto1Exception(HttpStatus.resolve(response.statusCode().value()), "Ocorreu um erro inesperado")))
                .build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build()
                .createClient(PagamentoAclHttpClient.class);
    }
}
