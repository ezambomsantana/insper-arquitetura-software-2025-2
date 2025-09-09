package br.edu.insper.cinema.sessao;

import br.edu.insper.cinema.filme.Filme;
import br.edu.insper.cinema.filme.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessaoService {
    private final Map<String, Sessao> sessoes = new HashMap<>();

    @Autowired
    private FilmeService filmeService;

    public List<Sessao> listarTodos() {
        return new ArrayList<>(sessoes.values());
    }

    public Sessao buscarPorId(String id) {
        return sessoes.get(id);
    }

    public Sessao salvar(Sessao sessao) {

        Filme filme = filmeService.buscarPorId(sessao.getFilme().getId());

        if (filme == null) {
            throw new RuntimeException("Filme não encontrado");
        }

        sessao.setId(UUID.randomUUID().toString());
        sessoes.put(sessao.getId(), sessao);
        return sessao;
    }

    public Sessao atualizar(String id, Sessao sessaoAtualizar) {
        Sessao sessao = buscarPorId(id);

        if (sessaoAtualizar.getHorario() != null) {
            sessao.setHorario(sessaoAtualizar.getHorario());
        }

        if (sessaoAtualizar.getSala() != null) {
            sessao.setSala(sessaoAtualizar.getSala());
        }

        return sessao;
    }

    public void deletar(String id) {
        sessoes.remove(id);
    }
}
