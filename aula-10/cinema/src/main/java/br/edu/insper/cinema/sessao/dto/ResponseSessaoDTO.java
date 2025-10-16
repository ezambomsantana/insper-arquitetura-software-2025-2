package br.edu.insper.cinema.sessao.dto;

import br.edu.insper.cinema.sessao.model.Sessao;

public record ResponseSessaoDTO(Integer id, String sala, String tituloFilme) {

    public static ResponseSessaoDTO toDto(Sessao sessao) {
        return new ResponseSessaoDTO(
                sessao.getId(),
                sessao.getSala(),
                sessao.getFilme().getTitulo()
        );
    }

}
