package org.example;

public class Produto {
    String nome;
    Double preco;
    Integer quantidade;

    public void aumentarPreco(double porcentagem) {
        preco += preco * porcentagem / 100;
    }

    public void alterarEstoque(Integer quantidadeNova) {
        quantidade += quantidadeNova;
    }
}
