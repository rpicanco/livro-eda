package com.ecommerce.abc.pagamentos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PagamentoApp {

    public static void main(String[] args) {
        SpringApplication.run(PagamentoApp.class, args);
    }
}
