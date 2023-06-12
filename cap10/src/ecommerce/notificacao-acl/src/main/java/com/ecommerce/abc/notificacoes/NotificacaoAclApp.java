package com.ecommerce.abc.notificacoes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class NotificacaoAclApp {

    public static void main(String[] args) {
        SpringApplication.run(NotificacaoAclApp.class, args);
    }
}
