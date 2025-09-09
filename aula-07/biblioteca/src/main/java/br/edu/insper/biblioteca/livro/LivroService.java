package br.edu.insper.biblioteca.livro;

import br.edu.insper.biblioteca.autor.AutorService;
import br.edu.insper.biblioteca.categoria.CategoriaService;
import br.edu.insper.biblioteca.autor.Autor;
import br.edu.insper.biblioteca.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroService {
    private final Map<String, Livro> livros = new HashMap<>();
    
    @Autowired
    private AutorService autorService;
    
    @Autowired
    private CategoriaService categoriaService;

    public Collection<Livro> listarTodos() {
        return livros.values();
    }

    public Livro buscarPorIsbn(String isbn) {
        return livros.get(isbn);
    }

    public Livro salvar(Livro livro) {
        // Verifica se o autor existe
        Autor autor = autorService.buscarPorCpf(livro.getAutor().getCpf());
        if (autor == null) {
            throw new RuntimeException("Autor não encontrado com o CPF: " + livro.getAutor().getCpf());
        }
        
        // Verifica se a categoria existe
        Categoria categoria = categoriaService.buscarPorId(livro.getCategoria().getId());
        if (categoria == null) {
            throw new RuntimeException("Categoria não encontrada com o ID: " + livro.getCategoria().getId());
        }
        
        livro.setAutor(autor);
        livro.setCategoria(categoria);

        categoria.getLivros().add(livro);
        autor.getLivros().add(livro);

        livros.put(livro.getIsbn(), livro);
        return livro;
    }

    public void deletar(String isbn) {
        livros.remove(isbn);
    }

}
