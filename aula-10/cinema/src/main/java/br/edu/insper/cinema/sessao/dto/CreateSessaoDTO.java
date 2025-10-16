package br.edu.insper.cinema.sessao.dto;

public record CreateSessaoDTO(String horario, String sala,
                              Integer totalIngressos, Integer filmeId) {

}
