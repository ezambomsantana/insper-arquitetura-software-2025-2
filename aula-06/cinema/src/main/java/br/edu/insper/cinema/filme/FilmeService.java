package br.edu.insper.cinema.filme;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmeService {
    private final Map<String, Filme> filmes = new HashMap<>();

    public List<Filme> listarTodos() {
        return new ArrayList<>(filmes.values());
    }

    public Filme buscarPorId(String id) {
        return filmes.get(id);
    }

    public Filme salvar(Filme filme) {
        filme.setId(UUID.randomUUID().toString());
        filmes.put(filme.getId(), filme);
        return filme;
    }

    public Filme atualizar(String id, Filme filmeAtualizado) {
        Filme filme = buscarPorId(id);

        if (filmeAtualizado.getGenero() != null) {
            filme.setGenero(filmeAtualizado.getGenero());
        }

        if (filmeAtualizado.getDuracao() != null) {
            filme.setDuracao(filmeAtualizado.getDuracao());
        }

        return filme;

    }

    public void deletar(String id) {
        filmes.remove(id);
    }
}
