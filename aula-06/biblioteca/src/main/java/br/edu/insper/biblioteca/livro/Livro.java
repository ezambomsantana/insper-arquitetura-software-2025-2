package br.edu.insper.biblioteca.livro;

import br.edu.insper.biblioteca.autor.Autor;
import br.edu.insper.biblioteca.categoria.Categoria;

public class Livro {
    private String isbn;
    private String titulo;
    private Integer ano;
    private Autor autor;
    private Categoria categoria;

    public Livro() {
    }

    public Livro(String isbn, String titulo, Integer ano, Autor autor, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
