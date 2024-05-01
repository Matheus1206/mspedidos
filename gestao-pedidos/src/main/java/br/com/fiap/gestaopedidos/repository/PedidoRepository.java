package br.com.fiap.gestaopedidos.repository;

import br.com.fiap.gestaopedidos.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
