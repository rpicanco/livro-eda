package com.ecommerce.abc.qualificacoes.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import com.ecommerce.abc.qualificacoes.model.State;
import com.ecommerce.abc.qualificacoes.repository.StateRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class StateCollectionInitialization {

    private final ResourceLoader resourceLoader;

    private final StateRepository repository;

    private final ObjectMapper objectMapper;

    @EventListener
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        try {
            if (repository.count() > 0)
                return;

            String json = resourceLoader.getResource("classpath:data/state.json")
                    .getContentAsString(StandardCharsets.UTF_8);

            List<State> states = objectMapper.readValue(json, new TypeReference<>() {
            });

            log.info("Populando database... " + states);

            repository.saveAll(states);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
