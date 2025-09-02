package br.edu.insper.funcionario.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public Collection<Funcionario> listaFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Funcionario cadastraFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @GetMapping("/{cpf}")
    public Funcionario getFuncionario(@PathVariable String cpf) {
        return funcionarioService.getFuncionario(cpf);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFuncionario(@PathVariable String cpf) {
        funcionarioService.deletarFuncionario(cpf);
    }

    /*
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
        }
        return func;
    }*/


}
