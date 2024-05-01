package br.com.fiap.gestaopedidos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pedido {

    @Id
    @JsonProperty("pedido_id")
    private String id;

    private String idCliente;

    private List<Itens> itens;

    public Pedido(String idCliente, List<Itens> itens){
        this.idCliente = idCliente;
        this.itens = itens;
    }

}
