package br.edu.insper.cinema.cliente;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {
    private final Map<String, Cliente> clientes = new HashMap<>();

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    public Cliente buscarPorId(String id) {
        return clientes.get(id);
    }

    public Cliente salvar(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
        return cliente;
    }

    public Cliente atualizar(String cpf, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(cpf);

        if (clienteAtualizado.getNome() != null) {
            cliente.setNome(clienteAtualizado.getNome());
        }

        if (clienteAtualizado.getTelefone() != null) {
            cliente.setTelefone(clienteAtualizado.getTelefone());
        }

        return cliente;
    }

    public void deletar(String cpf) {
        clientes.remove(cpf);
    }
}
