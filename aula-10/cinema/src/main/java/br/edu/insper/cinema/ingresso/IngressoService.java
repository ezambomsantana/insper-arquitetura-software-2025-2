package br.edu.insper.cinema.ingresso;

import br.edu.insper.cinema.cliente.Cliente;
import br.edu.insper.cinema.cliente.ClienteService;
import br.edu.insper.cinema.sessao.model.Sessao;
import br.edu.insper.cinema.sessao.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngressoService {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private IngressoRepository ingressoRepository;

    public List<Ingresso> listarTodos() {
        return ingressoRepository.findAll();
    }

    public Ingresso buscarPorId(Integer id) {
        return ingressoRepository.findById(id).get();
    }

    public Ingresso salvar(Ingresso ingresso) {

        Sessao sessao = sessaoService.buscarPorId(ingresso.getSessao().getId());
        if (sessao == null) {
            throw new RuntimeException("Sessão não encontrada");
        }

        Cliente cliente = clienteService.buscarPorId(ingresso.getCliente().getId());
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        ingresso.setCliente(cliente);
        ingresso.setSessao(sessao);

        cliente.getIngressos().add(ingresso);

        return ingressoRepository.save(ingresso);
    }

    public Ingresso atualizar(Integer id, Ingresso ingressoAtualizar) {
        Ingresso ingresso = buscarPorId(id);

        if (ingressoAtualizar.getCliente() != null) {
            Cliente cliente = clienteService.buscarPorId(ingresso.getCliente().getId());
            if (cliente == null) {
                throw new RuntimeException("Cliente não encontrado");
            }
            ingresso.setCliente(cliente);
        }


        return ingressoRepository.save(ingresso);
    }

    public void deletar(Integer id) {
        ingressoRepository.deleteById(id);
    }
}
