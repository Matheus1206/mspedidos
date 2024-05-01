package br.com.fiap.gestaopedidos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PedidoRequest(@JsonProperty(value = "cliente_id") String clienteId, List<Itens> itens) {
}
