package br.com.fiap.gestaopedidos.dto;

import br.com.fiap.gestaopedidos.model.Itens;
import br.com.fiap.gestaopedidos.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record PedidoResponse(@JsonProperty("pedido_id") String id, @JsonProperty("cliente_id") String idCliente, List<Itens> itens){
    public PedidoResponse(Pedido pedido) {
        this(pedido.getId(), pedido.getIdCliente(),pedido.getItens());
    }
}
