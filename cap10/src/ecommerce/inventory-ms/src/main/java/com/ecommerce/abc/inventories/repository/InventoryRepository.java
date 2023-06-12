package com.ecommerce.abc.inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.inventories.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
