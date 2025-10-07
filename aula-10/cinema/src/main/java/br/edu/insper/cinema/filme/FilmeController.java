package br.edu.insper.cinema.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public Page<Filme> listarTodos(@RequestParam(name = "duracao") Integer duracao,
                                   Pageable pageable) {
        return filmeService.listarTodos(duracao, pageable);
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Integer id) {
        return filmeService.buscarPorId(id);
    }

    @PostMapping
    public Filme criar(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Integer id, @RequestBody Filme filme) {
        return filmeService.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        filmeService.deletar(id);
    }
}
