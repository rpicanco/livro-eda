package com.ecommerce.abc.envios;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class EnvioApp {

    public static void main(String[] args) {
        SpringApplication.run(EnvioApp.class, args);
    }
}
