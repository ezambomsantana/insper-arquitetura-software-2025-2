package br.edu.insper.biblioteca.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Erro responseStatusExceptionHandler(ResponseStatusException responseStatusException) {

        Erro erro = new Erro();
        erro.setMensagem(responseStatusException.getReason());
        erro.setHorario(LocalDateTime.now());
        erro.setStatusCode(responseStatusException.getStatusCode().value());

        return erro;


    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Erro responseStatusExceptionHandler(ResourceNotFoundException resourceNotFoundException) {

        Erro erro = new Erro();
        erro.setMensagem(resourceNotFoundException.getMessage());
        erro.setHorario(LocalDateTime.now());
        erro.setStatusCode(HttpStatus.NOT_FOUND.value());

        return erro;


    }

}