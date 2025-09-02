package br.edu.insper.funcionario.departamento;

import br.edu.insper.funcionario.funcionario.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Departamento {

    private String id;
    private String nome;

    @JsonIgnore
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }
}
