package br.edu.insper.cinema.sessao.service;

import br.edu.insper.cinema.filme.Filme;
import br.edu.insper.cinema.filme.FilmeService;
import br.edu.insper.cinema.sessao.dto.RelatorioSessaoDTO;
import br.edu.insper.cinema.sessao.repository.SessaoRepository;
import br.edu.insper.cinema.sessao.dto.CreateSessaoDTO;
import br.edu.insper.cinema.sessao.dto.EditSessaoDTO;
import br.edu.insper.cinema.sessao.dto.ResponseSessaoDTO;
import br.edu.insper.cinema.sessao.model.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeService filmeService;

    public List<ResponseSessaoDTO> listarTodos() {
        return sessaoRepository
                .findAll()
                .stream()
                .map(sessao -> ResponseSessaoDTO.toDto(sessao))
                .toList();
    }

    public Sessao buscarPorId(Integer id) {
        return sessaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ResponseSessaoDTO getPorId(Integer id) {
        Sessao sessao = buscarPorId(id);
        return ResponseSessaoDTO.toDto(sessao);
    }

    public ResponseSessaoDTO salvar(CreateSessaoDTO createSessaoDTO) {

        Filme filme = filmeService.buscarPorId(createSessaoDTO.filmeId());

        if (filme == null) {
            throw new RuntimeException("Filme não encontrado");
        }
        Sessao sessao = new Sessao();
        sessao.setSala(createSessaoDTO.sala());
        sessao.setHorario(createSessaoDTO.horario());
        sessao.setTotalIngressos(createSessaoDTO.totalIngressos());
        sessao.setFilme(filme);

        sessao = sessaoRepository.save(sessao);

        return ResponseSessaoDTO.toDto(sessao);
    }

    public ResponseSessaoDTO atualizar(Integer id, EditSessaoDTO sessaoAtualizar) {
        Sessao sessao = buscarPorId(id);

        if (sessaoAtualizar.horario() != null) {
            sessao.setHorario(sessaoAtualizar.horario());
        }

        if (sessaoAtualizar.sala() != null) {
            sessao.setSala(sessaoAtualizar.sala());
        }

        sessao = sessaoRepository.save(sessao);

        return ResponseSessaoDTO.toDto(sessao);
    }

    public void deletar(Integer id) {
        sessaoRepository.deleteById(id);
    }

    public RelatorioSessaoDTO gerarRelatorio(Integer id) {

        Sessao sessao = sessaoRepository.findById(id).get();

        return new RelatorioSessaoDTO(sessao.getId(),
                sessao.getTotalIngressos(),
                sessao.getIngressos().size());

    }
}
