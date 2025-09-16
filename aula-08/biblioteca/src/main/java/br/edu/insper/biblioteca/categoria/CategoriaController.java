package br.edu.insper.biblioteca.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public Collection<Categoria> listarCategorias() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Categoria buscarCategoria(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {

        if (categoria.getNome() == null || categoria.getNome().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome é obrigatorio");
        }

        if (categoria.getDescricao() == null || categoria.getDescricao().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição é obrigatorio");
        }


        return categoriaService.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void removerCategoria(@PathVariable Long id) {
        categoriaService.deletar(id);
    }
}
