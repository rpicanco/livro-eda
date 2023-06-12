package com.ecommerce.abc.pagamentos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.abc.pagamentos.model.Pagamento;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
}
