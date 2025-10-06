package br.edu.insper.cinema.sessao;

import br.edu.insper.cinema.filme.Filme;
import br.edu.insper.cinema.filme.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeService filmeService;

    public List<Sessao> listarTodos() {
        return sessaoRepository.findAll();
    }

    public Sessao buscarPorId(Integer id) {
        return sessaoRepository.findById(id).get();
    }

    public Sessao salvar(Sessao sessao) {

        Filme filme = filmeService.buscarPorId(sessao.getFilme().getId());

        if (filme == null) {
            throw new RuntimeException("Filme não encontrado");
        }
        sessao.setFilme(filme);

        return sessaoRepository.save(sessao);
    }

    public Sessao atualizar(Integer id, Sessao sessaoAtualizar) {
        Sessao sessao = buscarPorId(id);

        if (sessaoAtualizar.getHorario() != null) {
            sessao.setHorario(sessaoAtualizar.getHorario());
        }

        if (sessaoAtualizar.getSala() != null) {
            sessao.setSala(sessaoAtualizar.getSala());
        }

        return sessao;
    }

    public void deletar(Integer id) {
        sessaoRepository.deleteById(id);
    }
}
