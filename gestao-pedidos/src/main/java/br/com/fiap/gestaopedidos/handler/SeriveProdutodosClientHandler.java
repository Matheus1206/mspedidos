package br.com.fiap.gestaopedidos.handler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeriveProdutodosClientHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({FeignException.class})
    public String produtoSemEstoqueHandler(FeignException exception){
        return exception.getMessage();
    }

}
