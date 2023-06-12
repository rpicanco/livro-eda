package com.ecommerce.abc.qualificacoes.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("state")
@Jacksonized
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class State {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String acronym;
}
