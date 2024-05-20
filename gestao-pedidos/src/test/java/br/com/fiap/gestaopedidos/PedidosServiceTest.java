package br.com.fiap.gestaopedidos;

import br.com.fiap.gestaopedidos.client.ServiceProdutosClient;
import br.com.fiap.gestaopedidos.dto.PedidoRequest;
import br.com.fiap.gestaopedidos.dto.PedidoResponse;
import br.com.fiap.gestaopedidos.model.Itens;
import br.com.fiap.gestaopedidos.model.Pedido;
import br.com.fiap.gestaopedidos.repository.PedidoRepository;
import br.com.fiap.gestaopedidos.services.PedidosServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PedidosServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidosServices pedidosServices;

    @Mock
    private ServiceProdutosClient serviceProdutosClient;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveCriarPedido(){
        PedidoRequest pedidoRequest = new PedidoRequest("1", Arrays.asList(new Itens("1", 3)));
        when(serviceProdutosClient.verificaDisponibilidadeEstoque(anyString(), anyInt())).thenReturn(true);
        Pedido pedido = new Pedido(pedidoRequest.clienteId(), pedidoRequest.itens());
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        ResponseEntity<PedidoResponse> responseResponseEntity = pedidosServices.salvarPedido(pedidoRequest);
        assertNotNull(responseResponseEntity);
    }

    @Test
    void deveListarTodosOsPedido(){
        List<PedidoResponse> lista = new ArrayList<>();
        Pedido pedido = new Pedido("1", Arrays.asList(new Itens("1", 3)));
        PedidoResponse pedidoResponse = new PedidoResponse(pedido);
        lista.add(pedidoResponse);
        when(pedidoRepository.findAll().stream().map(PedidoResponse::new).toList()).thenReturn(lista);
        ResponseEntity<List<PedidoResponse>> responseResponseEntity = pedidosServices.getTodosOsPedido();
        assertNotNull(responseResponseEntity);
    }

    @Test
    void deveTodosOPedidoPorId(){
        Pedido pedido = new Pedido("1", Arrays.asList(new Itens("1", 3)));
        when(pedidoRepository.findById(anyString())).thenReturn(Optional.of(pedido));
        ResponseEntity<PedidoResponse> pedidoById = pedidosServices.getPedidoById("1");
        assertNotNull(pedidoById);
    }


}
