package br.com.fiap.gestaopedidos.controller;

import br.com.fiap.gestaopedidos.dto.PedidoRequest;
import br.com.fiap.gestaopedidos.dto.PedidoResponse;
import br.com.fiap.gestaopedidos.services.PedidosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private final PedidosServices pedidosServices;

    public PedidosController(PedidosServices pedidosServices) {
        this.pedidosServices = pedidosServices;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequest pedidoRequest){
        return pedidosServices.salvarPedido(pedidoRequest);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> todosOsPedidos(){
        return pedidosServices.getTodosOsPedido();
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponse> pedidoById(@PathVariable String id){
        return pedidosServices.getPedidoById(id);
    }

}
