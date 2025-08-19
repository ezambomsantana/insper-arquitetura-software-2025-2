package org.example;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario {

    public String nome;
    public String funcao;
    public Float salario;
    public LocalDate dataContratacao;

    public void mudarFuncao(String funcaoNova) {
        funcao = funcaoNova;
    }

    public void aumentarSalario(float porcentagem) {
        salario +=  (salario * porcentagem / 100);
    }

    public Integer anosEmpresa() {
        return Period.between(dataContratacao, LocalDate.now()).getYears();
    }

}
