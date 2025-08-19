package org.example.atores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Filme {

    public String nome;
    public LocalDate dataLancamento;
    public String diretor;
    private ArrayList<String> atores = new ArrayList<>();

    public void getNomeDoFilme() {
        System.out.println(nome);
    }

    public void adicionarAtor(String nome) {

        if (nome.length() > 5) {
            atores.add(nome);
            System.out.println(String.format("Ator %s adicionado", nome));
        } else {
            System.out.println("nome inválido");
        }
    }

    public static void soma(Integer x, Integer y) {
        System.out.println(x + y);
    }

}
