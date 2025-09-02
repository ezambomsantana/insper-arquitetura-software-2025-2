package br.edu.insper.funcionario.funcionario;

import br.edu.insper.funcionario.departamento.Departamento;
import br.edu.insper.funcionario.departamento.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FuncionarioService {

    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();

    @Autowired
    private DepartamentoService departamentoService;

    public Collection<Funcionario> listarFuncionarios() {
        return funcionarios.values();
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {

        Departamento departamento = departamentoService.getDepartamento(funcionario.getDepartamento().getId());
        if (departamento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        funcionario.setDepartamento(departamento);
        departamento.addFuncionario(funcionario);

        funcionarios.put(funcionario.getCpf(), funcionario);
        return funcionario;
    }

    public void deletarFuncionario(String cpf) {
        funcionarios.remove(cpf);
    }

    public Funcionario getFuncionario(String cpf) {
        return funcionarios.get(cpf);
    }
}
