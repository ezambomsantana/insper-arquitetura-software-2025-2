package br.edu.insper.biblioteca.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public Collection<Autor> listarAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public Autor buscarAutor(@PathVariable String cpf) {
        return autorService.buscarPorCpf(cpf);
    }

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @DeleteMapping("/{cpf}")
    public void removerAutor(@PathVariable String cpf) {
        autorService.deletar(cpf);
    }
}
