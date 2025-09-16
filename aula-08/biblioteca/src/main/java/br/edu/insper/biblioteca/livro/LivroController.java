package br.edu.insper.biblioteca.livro;

import br.edu.insper.biblioteca.autor.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public Collection<Livro> listarLivros() {
        return livroService.listarTodos();
    }

    @GetMapping("/{isbn}")
    public Livro buscarLivro(@PathVariable String isbn) {
        return livroService.buscarPorIsbn(isbn);
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @DeleteMapping("/{isbn}")
    public void removerLivro(@PathVariable String isbn) {
        livroService.deletar(isbn);
    }

    @PutMapping("/{isbn}")
    public Livro editarLivro(@PathVariable String isbn, @RequestBody Livro livro) {
        return livroService.editarLivro(isbn, livro);
    }

}
