package br.com.fiap.gestaopedidos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Pedido {

    @Id
    private String id;

    private String idCliente;

    private List<Itens> itens;

}
