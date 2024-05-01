package br.com.fiap.gestaopedidos.controller;

import br.com.fiap.gestaopedidos.model.PedidoRequest;
import br.com.fiap.gestaopedidos.services.PedidosServices;
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
    public void criar(@RequestBody PedidoRequest pedidoRequest){
        pedidosServices.salvarPedido(pedidoRequest);
    }

}
