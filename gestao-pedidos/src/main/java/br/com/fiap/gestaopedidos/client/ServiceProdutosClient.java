package br.com.fiap.gestaopedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pedido-service", url = "http://localhost:8080/api/produtos")
public interface ServiceProdutosClient {

    @PostMapping("/{id}/{quantidade}/estoque")
    Boolean verificaDisponibilidadeEstoque(@PathVariable("id") String id, @PathVariable("quantidade") Integer quantidade);

}
