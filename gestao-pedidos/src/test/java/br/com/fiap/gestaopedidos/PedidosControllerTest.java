package br.com.fiap.gestaopedidos;

import br.com.fiap.gestaopedidos.dto.PedidoRequest;
import br.com.fiap.gestaopedidos.dto.PedidoResponse;
import br.com.fiap.gestaopedidos.model.Itens;
import br.com.fiap.gestaopedidos.repository.PedidoRepository;
import br.com.fiap.gestaopedidos.services.PedidosServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PedidosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidosServices pedidosServices;

    @Mock
    private PedidoRepository pedidoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void criarPedido() throws Exception {
        PedidoRequest pedidoRequest = new PedidoRequest("1", Arrays.asList(new Itens()));
        ResponseEntity<PedidoResponse> responseResponseEntity = ResponseEntity.ok(new PedidoResponse("1", "1",Arrays.asList(new Itens())));
        given(pedidosServices.salvarPedido(any(PedidoRequest.class))).willReturn(responseResponseEntity);
        mockMvc.perform(post("/api/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(pedidoRequest)))
                .andExpect(status().isOk());

    }

    @Test
    void pegaUmPedido() throws Exception {
        ResponseEntity<PedidoResponse> responseResponseEntity = ResponseEntity.ok(new PedidoResponse("1", "1",Arrays.asList(new Itens())));
        given(pedidosServices.getPedidoById(anyString())).willReturn(responseResponseEntity);
        mockMvc.perform(get("/api/pedidos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk());

    }

    @Test
    void pegaTodosPedido() throws Exception {
        ResponseEntity<List<PedidoResponse>> responseResponseEntity = ResponseEntity.ok().body(pedidoRepository.findAll().stream().map(PedidoResponse::new).toList());
        given(pedidosServices.getTodosOsPedido()).willReturn(responseResponseEntity);
        mockMvc.perform(get("/api/pedidos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
