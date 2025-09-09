package br.edu.insper.cinema.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> listarTodos() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable String id) {
        return filmeService.buscarPorId(id);
    }

    @PostMapping
    public Filme criar(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable String id, @RequestBody Filme filme) {
        return filmeService.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        filmeService.deletar(id);
    }
}
