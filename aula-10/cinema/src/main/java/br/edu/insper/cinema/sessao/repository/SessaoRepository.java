package br.edu.insper.cinema.sessao.repository;

import br.edu.insper.cinema.sessao.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
}
