package br.edu.insper.biblioteca.common;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
