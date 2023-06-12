package com.ecommerce.abc.qualificacoes.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ecommerce.abc.commons.dto.OrderDto;
import com.ecommerce.abc.qualificacoes.broker.QualificacaoOutput;
import com.ecommerce.abc.qualificacoes.model.State;
import com.ecommerce.abc.qualificacoes.repository.StateRepository;
import com.ecommerce.abc.qualificacoes.service.QualificacaoService;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class QualificacaoServiceImpl implements QualificacaoService {

    private final StateRepository repository;

    private final QualificacaoOutput output;

    @Override
    public void processarCriacaoDePedido(OrderDto order) {
        State state = repository.findByAcronym(order.getCustomer().getDeliveryAddress().getState());

        if (state != null) {
            output.pedidoQualificado(order);
            log.info(format("[%s] Qualificação do pedido concluida", order.getId()));
        } else {
            output.pedidoRecusado(order);
            log.info(format("[%s] Qualificação do pedido recusada", order.getId()));
        }
    }
}
