package br.edu.insper.cinema.sessao.controller;

import br.edu.insper.cinema.sessao.dto.RelatorioSessaoDTO;
import br.edu.insper.cinema.sessao.service.SessaoService;
import br.edu.insper.cinema.sessao.dto.CreateSessaoDTO;
import br.edu.insper.cinema.sessao.dto.EditSessaoDTO;
import br.edu.insper.cinema.sessao.dto.ResponseSessaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessoes")
@Tag(name = "API de Sessões", description = "API de gerenciamento de sessão do cinema")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @Operation(
            summary = "Lista todas as sessões",
            description = "Retorna uma lista com todas as sessões salvas no banco de dados"

    )
    @GetMapping
    public List<ResponseSessaoDTO> listarTodos() {
        return sessaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseSessaoDTO buscarPorId(@PathVariable Integer id) {
        return sessaoService.getPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSessaoDTO criar(@RequestBody CreateSessaoDTO sessao) {
        return sessaoService.salvar(sessao);
    }

    @PutMapping("/{id}")
    public ResponseSessaoDTO atualizar(@PathVariable Integer id, @RequestBody EditSessaoDTO cliente) {
        return sessaoService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        sessaoService.deletar(id);
    }

    @GetMapping("/{id}/relatorio")
    public RelatorioSessaoDTO getRelatorio(@PathVariable Integer id) {
        return sessaoService.gerarRelatorio(id);
    }
}
