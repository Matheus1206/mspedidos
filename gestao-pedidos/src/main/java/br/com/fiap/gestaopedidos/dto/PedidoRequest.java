package br.com.fiap.gestaopedidos.dto;

import br.com.fiap.gestaopedidos.model.Itens;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoRequest(@JsonProperty(value = "cliente_id") @NotBlank String clienteId, @NotNull List<Itens> itens) {
}
