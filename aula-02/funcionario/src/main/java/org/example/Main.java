package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario();
        String opcao = "0";
        while (!opcao.equals("3")) {
            System.out.println("""
                        1 - Cadastrar funcionario
                        2 - Listar funcionario
                    """);

            opcao = System.console().readLine();

            if (opcao.equals("1")) {

                String nome = System.console().readLine("Digite o nome");
                String salario = System.console().readLine("Digite o salario");
                String funcao = System.console().readLine("Digite a funcao");

                gerenciaFuncionario.cadastrarFuncionario(nome, salario, funcao);

            }

            if (opcao.equals("2")) {
                gerenciaFuncionario.listarFuncionarios();
            }

        }




    }


}