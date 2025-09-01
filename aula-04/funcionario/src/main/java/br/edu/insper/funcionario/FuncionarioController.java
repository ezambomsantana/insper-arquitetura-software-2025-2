package br.edu.insper.funcionario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();

    @GetMapping
    public Collection<Funcionario> listaFuncionarios() {
        return funcionarios.values();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastraFuncionario(@RequestBody Funcionario funcionario) {
        funcionarios.put(funcionario.getCpf(), funcionario);
        return funcionario;
    }

    @GetMapping("/{cpf}")
    public Funcionario getFuncionario(@PathVariable String cpf) {
        return funcionarios.get(cpf);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFuncionario(@PathVariable String cpf) {
        funcionarios.remove(cpf);
    }

    @PutMapping("/{cpf}")
    public Funcionario editarFuncionario(@PathVariable String cpf, @RequestBody Funcionario funcionario) {

        Funcionario func = funcionarios.get(cpf);
        if (func != null) {
            if (funcionario.getNome() != null) {
                func.setNome(funcionario.getNome());
            }
            if (funcionario.getSalario() != null) {
                func.setSalario(funcionario.getSalario());
            }
            if (funcionario.getDepartamento() != null) {
                func.setDepartamento(funcionario.getDepartamento());
            }
        }
        return func;
    }


}
