package br.edu.insper.cinema.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    public List<Sessao> listarTodos() {
        return sessaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Sessao buscarPorId(@PathVariable String id) {
        return sessaoService.buscarPorId(id);
    }

    @PostMapping
    public Sessao criar(@RequestBody Sessao cliente) {
        return sessaoService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Sessao atualizar(@PathVariable String id, @RequestBody Sessao cliente) {
        return sessaoService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        sessaoService.deletar(id);
    }
}
