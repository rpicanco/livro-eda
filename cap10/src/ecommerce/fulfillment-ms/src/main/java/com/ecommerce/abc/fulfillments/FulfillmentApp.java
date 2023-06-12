package com.ecommerce.abc.fulfillments;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class FulfillmentApp {

    public static void main(String[] args) {
        SpringApplication.run(FulfillmentApp.class, args);
    }
}
