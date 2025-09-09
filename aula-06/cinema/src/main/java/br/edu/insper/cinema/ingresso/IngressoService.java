package br.edu.insper.cinema.ingresso;

import br.edu.insper.cinema.cliente.Cliente;
import br.edu.insper.cinema.cliente.ClienteService;
import br.edu.insper.cinema.sessao.Sessao;
import br.edu.insper.cinema.sessao.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngressoService {
    private final Map<String, Ingresso> ingressos = new HashMap<>();

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private ClienteService clienteService;

    public List<Ingresso> listarTodos() {
        return new ArrayList<>(ingressos.values());
    }

    public Ingresso buscarPorId(String id) {
        return ingressos.get(id);
    }

    public Ingresso salvar(Ingresso ingresso) {

        Sessao sessao = sessaoService.buscarPorId(ingresso.getSessao().getId());
        if (sessao == null) {
            throw new RuntimeException("Sessão não encontrada");
        }

        Cliente cliente = clienteService.buscarPorId(ingresso.getCliente().getCpf());
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        ingresso.setId(UUID.randomUUID().toString());
        ingresso.setCliente(cliente);
        ingresso.setSessao(sessao);

        ingressos.put(ingresso.getId(), ingresso);
        return ingresso;
    }

    public Ingresso atualizar(String id, Ingresso ingressoAtualizar) {
        Ingresso ingresso = buscarPorId(id);

        if (ingressoAtualizar.getCliente() != null) {
            Cliente cliente = clienteService.buscarPorId(ingresso.getCliente().getCpf());
            if (cliente == null) {
                throw new RuntimeException("Cliente não encontrado");
            }
            ingresso.setCliente(cliente);
        }


        return ingresso;
    }

    public void deletar(String id) {
        ingressos.remove(id);
    }
}
