package com.ecommerce.abc.fulfillments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.fulfillments.model.Fulfillment;

import java.util.Optional;

public interface FulfillmentRepository extends MongoRepository<Fulfillment, String> {
    Optional<Fulfillment> findByOrderId(String orderId);
}
