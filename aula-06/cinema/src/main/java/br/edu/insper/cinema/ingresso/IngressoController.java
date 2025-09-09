package br.edu.insper.cinema.ingresso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    @GetMapping
    public List<Ingresso> listarTodos() {
        return ingressoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Ingresso buscarPorId(@PathVariable String id) {
        return ingressoService.buscarPorId(id);
    }

    @PostMapping
    public Ingresso criar(@RequestBody Ingresso ingresso) {
        return ingressoService.salvar(ingresso);
    }

    @PutMapping("/{id}")
    public Ingresso atualizar(@PathVariable String id, @RequestBody Ingresso ingresso) {
        return ingressoService.atualizar(id, ingresso);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        ingressoService.deletar(id);
    }
}
