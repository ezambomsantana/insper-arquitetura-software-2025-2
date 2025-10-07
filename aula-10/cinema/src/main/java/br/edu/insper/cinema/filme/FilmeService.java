package br.edu.insper.cinema.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Page<Filme> listarTodos(Integer duracao, Pageable pageable) {
        return filmeRepository.findByDuracaoGreaterThanEqual(duracao, pageable);
    }

    public Filme buscarPorId(Integer id) {
        return filmeRepository.findById(id).get();
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme atualizar(Integer id, Filme filmeAtualizado) {
        Filme filme = buscarPorId(id);

        if (filmeAtualizado.getGenero() != null) {
            filme.setGenero(filmeAtualizado.getGenero());
        }

        if (filmeAtualizado.getDuracao() != null) {
            filme.setDuracao(filmeAtualizado.getDuracao());
        }

        return filmeRepository.save(filme);

    }

    public void deletar(Integer id) {
        filmeRepository.deleteById(id);
    }
}
