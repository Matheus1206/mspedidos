package br.com.fiap.gestaopedidos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@ToString
public class Itens {

    @JsonProperty("produto_id")
    private String produtoId;
    @Min(1)
    private Integer quantidade;

}
