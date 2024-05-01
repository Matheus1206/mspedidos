package br.com.fiap.gestaopedidos.services;

import br.com.fiap.gestaopedidos.client.ServiceProdutosClient;
import br.com.fiap.gestaopedidos.model.PedidoRequest;
import br.com.fiap.gestaopedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidosServices {

    private final PedidoRepository pedidoRepository;


    private final ServiceProdutosClient serviceProdutosClient;

    public PedidosServices(PedidoRepository pedidoRepository, ServiceProdutosClient serviceProdutosClient) {
        this.pedidoRepository = pedidoRepository;
        this.serviceProdutosClient = serviceProdutosClient;
    }


    public void salvarPedido(PedidoRequest pedidoRequest) {
        pedidoRequest.itens().forEach(item -> serviceProdutosClient.verificaDisponibilidadeEstoque(item.getProdutoId(), item.getQuantidade()));
    }
}
