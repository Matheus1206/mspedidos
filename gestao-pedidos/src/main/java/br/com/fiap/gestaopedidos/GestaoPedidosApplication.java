package br.com.fiap.gestaopedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestaoPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoPedidosApplication.class, args);
	}

}
