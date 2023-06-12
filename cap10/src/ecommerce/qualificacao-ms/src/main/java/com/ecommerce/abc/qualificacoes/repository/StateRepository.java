package com.ecommerce.abc.qualificacoes.repository;

import com.ecommerce.abc.qualificacoes.model.State;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.qualificacoes.model.State;

public interface StateRepository extends MongoRepository<State, String> {
    State findByAcronym(String acronym);
}
