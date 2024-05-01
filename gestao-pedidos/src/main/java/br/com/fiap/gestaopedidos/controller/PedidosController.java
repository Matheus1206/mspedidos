package br.com.fiap.gestaopedidos.controller;

import br.com.fiap.gestaopedidos.dto.PedidoResponse;
import br.com.fiap.gestaopedidos.dto.PedidoRequest;
import br.com.fiap.gestaopedidos.services.PedidosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
