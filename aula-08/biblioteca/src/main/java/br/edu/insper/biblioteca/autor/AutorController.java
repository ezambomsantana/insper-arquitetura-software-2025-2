package br.edu.insper.biblioteca.autor;

import br.edu.insper.biblioteca.autenticacao.Usuario;
import br.edu.insper.biblioteca.autenticacao.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Collection<Autor> listarAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public Autor buscarAutor(@PathVariable String cpf) {
        return autorService.buscarPorCpf(cpf);
    }

    @PostMapping
    public Autor criarAutor(@RequestHeader(name = "token") String token ,@RequestBody Autor autor) {

        Usuario usuario = usuarioService.validarToken(token);

        return autorService.salvar(autor, usuario);
    }

    @PutMapping("/{cpf}")
    public Autor editarAutor(@PathVariable String cpf, @RequestBody Autor autor) {
        return autorService.editarAutor(cpf, autor);
    }

    @DeleteMapping("/{cpf}")
    public void removerAutor(@PathVariable String cpf) {
        autorService.deletar(cpf);
    }
}
