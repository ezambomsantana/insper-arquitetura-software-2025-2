package br.edu.insper.biblioteca.autor;

import br.edu.insper.biblioteca.autenticacao.Usuario;
import br.edu.insper.biblioteca.common.ResourceNotFoundException;
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
        Autor autor = autores.get(cpf);
        if (autor == null) {
            throw new ResourceNotFoundException("Autor não encontrado");
        }
        return autor;
    }

    public Autor salvar(Autor autor, Usuario usuario) {
        if (autor.getCpf() == null) {
            autor.setCpf("AUTO_" + nextId++);
        }
        autor.setEmailCriador(usuario.getEmail());
        autores.put(autor.getCpf(), autor);
        return autor;
    }

    public void deletar(String cpf) {
        autores.remove(cpf);
    }

    public Autor editarAutor(String cpf, Autor autor) {

        Autor autorEditar = autores.get(cpf);
        if (autorEditar != null) {
            if (autor.getNome() != null) {
                autorEditar.setNome(autor.getNome());
            }

            if (autor.getNacionalidade() != null) {
                autorEditar.setNacionalidade(autor.getNacionalidade());
            }
        }
        return autorEditar;
    }
}
