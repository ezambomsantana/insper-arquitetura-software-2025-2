package br.edu.insper.cinema.ingresso;

import br.edu.insper.cinema.cliente.Cliente;
import br.edu.insper.cinema.sessao.Sessao;

public class Ingresso {
    private String id;

    private Sessao sessao;
    private Cliente cliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
