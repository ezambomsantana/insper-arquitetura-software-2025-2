package org.example;

import org.example.atores.Filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        String var1 = "Teste";
        System.out.println(var1);

        Integer var2 = var1.length();
        System.out.println(var2);

        // comentario
        /*
         comentario
         */
        if (var2 > 10) {
            System.out.println("Maior que 10");
        } else if (var2 > 5) {
            System.out.println("Maior que 5");
        } else {
            System.out.println("Menor que 5");
        }

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        for (Integer num : lista) {
            System.out.println(num);
        }

        for (int i = 0; i < lista.size(); i++) {
            Integer num = lista.get(i);
            System.out.println(num);
        }

        lista.add(20);
        System.out.println(lista);

        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("s-1");
        conjunto.add("s-2");
        conjunto.add("s-1");

        System.out.println(conjunto);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "um");
        map.put(2, "dois");

        System.out.println(map);

        String nome = System.console().readLine("Digite o seu nome:");
        String idade = System.console().readLine("Digite a sua idade:");

        Integer idadeInt = Integer.parseInt(idade);
        Boolean.parseBoolean("true");

        String.valueOf(10);

        Filme filme = new Filme();
        filme.nome = "Senhor dos aneis";
        filme.dataLancamento = LocalDate.of(2020, 1, 1);
        filme.adicionarAtor("ator 2");


        HashMap<String, Filme> filmes = new HashMap<>();
        filmes.put("123", filme);


        Filme.soma(10,20);

    }
}