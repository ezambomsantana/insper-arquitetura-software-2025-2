package br.edu.insper.biblioteca.autor;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Service
public class AutorService {
    private final Map<String, Autor> autores = new HashMap<>();
    private Long nextId = 1L;

    public Collection<Autor> listarTodos() {
        return autores.values();
    }

    public Autor buscarPorCpf(String cpf) {
        return autores.get(cpf);
    }

    public Autor salvar(Autor autor) {
        if (autor.getCpf() == null) {
            autor.setCpf("AUTO_" + nextId++);
        }
        autores.put(autor.getCpf(), autor);
        return autor;
    }

    public void deletar(String cpf) {
        autores.remove(cpf);
    }
}
