package br.edu.insper.cinema.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Cliente findByCpf(String cpf);

    public List<Cliente> findByNome(String nome);

    public List<Cliente> findByNomeAndEmail(String nome,  String email);

}
