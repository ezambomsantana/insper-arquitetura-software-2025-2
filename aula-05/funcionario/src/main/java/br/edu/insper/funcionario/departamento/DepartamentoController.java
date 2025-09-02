package br.edu.insper.funcionario.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public Departamento salvarDepartamento(@RequestBody Departamento departamento) {

        if (departamento.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return departamentoService.salvarDepartamento(departamento);
    }

    @GetMapping
    public Collection<Departamento> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento getDepartamento(@PathVariable String id) {
        return departamentoService.getDepartamento(id);
    }

}
