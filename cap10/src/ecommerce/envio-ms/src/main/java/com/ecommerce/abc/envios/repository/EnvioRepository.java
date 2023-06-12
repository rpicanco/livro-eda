package com.ecommerce.abc.envios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.envios.model.Envio;

public interface EnvioRepository extends MongoRepository<Envio, String> {
}
