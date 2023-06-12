package com.ecommerce.abc.pedidos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PedidoApp {

    public static void main(String[] args) {
        SpringApplication.run(PedidoApp.class, args);
    }
}
