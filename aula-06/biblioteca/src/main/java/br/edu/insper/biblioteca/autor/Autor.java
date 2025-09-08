package br.edu.insper.biblioteca.autor;

import br.edu.insper.biblioteca.livro.Livro;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Autor {
    private String cpf;
    private String nome;
    private String nacionalidade;

    @JsonIgnore
    private ArrayList<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(String cpf, String nome, String nacionalidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    // Getters and Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
}
