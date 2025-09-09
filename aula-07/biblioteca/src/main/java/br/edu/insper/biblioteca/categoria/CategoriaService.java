package br.edu.insper.biblioteca.categoria;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Service
public class CategoriaService {
    private final Map<Long, Categoria> categorias = new HashMap<>();
    private Long nextId = 1L;

    public Collection<Categoria> listarTodas() {
        return categorias.values();
    }

    public Categoria buscarPorId(Long id) {
        return categorias.get(id);
    }

    public Categoria salvar(Categoria categoria) {
        if (categoria.getId() == null) {
            categoria.setId(nextId++);
        }
        categorias.put(categoria.getId(), categoria);
        return categoria;
    }

    public void deletar(Long id) {
        categorias.remove(id);
    }
}
