package br.edu.insper.cinema.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public Cliente buscarPorId(@PathVariable String cpf) {
        return clienteService.buscarPorId(cpf);
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{cpf}")
    public Cliente atualizar(@PathVariable String cpf, @RequestBody Cliente cliente) {
        return clienteService.atualizar(cpf, cliente);
    }

    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {
        clienteService.deletar(cpf);
    }
}
