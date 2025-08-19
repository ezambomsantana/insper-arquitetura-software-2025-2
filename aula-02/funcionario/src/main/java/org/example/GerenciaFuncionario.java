package org.example;

import java.util.ArrayList;

public class GerenciaFuncionario {

    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(String nome, String salario, String funcao) {
        Funcionario funcionario = new Funcionario();
        funcionario.nome = nome;
        funcionario.salario = Float.parseFloat(salario);
        funcionario.mudarFuncao(funcao);

        funcionarios.add(funcionario);

    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {

            System.out.println("--- Funcionario ---");
            System.out.println("Nome: " + funcionario.nome);
            System.out.println("Salário: " + funcionario.salario);
            System.out.println("Função: " + funcionario.funcao);

        }
    }

}
