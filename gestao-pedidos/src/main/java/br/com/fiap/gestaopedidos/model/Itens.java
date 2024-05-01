package br.com.fiap.gestaopedidos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@ToString
public class Itens {

    @JsonProperty("produto_id")
    private String produtoId;
    private Integer quantidade;

}
