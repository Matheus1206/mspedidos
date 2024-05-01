package br.com.fiap.gestaopedidos.services;

import br.com.fiap.gestaopedidos.client.ServiceProdutosClient;
import br.com.fiap.gestaopedidos.dto.PedidoResponse;
import br.com.fiap.gestaopedidos.model.Itens;
import br.com.fiap.gestaopedidos.model.Pedido;
import br.com.fiap.gestaopedidos.dto.PedidoRequest;
import br.com.fiap.gestaopedidos.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidosServices {

    private final PedidoRepository pedidoRepository;


    private final ServiceProdutosClient serviceProdutosClient;

    public PedidosServices(PedidoRepository pedidoRepository, ServiceProdutosClient serviceProdutosClient) {
        this.pedidoRepository = pedidoRepository;
        this.serviceProdutosClient = serviceProdutosClient;
    }


    public ResponseEntity<PedidoResponse> salvarPedido(PedidoRequest pedidoRequest) {
        List<Itens> list = new ArrayList<>();
        pedidoRequest.itens().forEach(item -> {
                    if(serviceProdutosClient.verificaDisponibilidadeEstoque(item.getProdutoId(), item.getQuantidade())){
                        list.add(item);
                    }
                }
        );
        Pedido pedido = pedidoRepository.save(new Pedido(pedidoRequest.clienteId(), list));
        return ResponseEntity.ok().body(new PedidoResponse(pedido));
    }
}
