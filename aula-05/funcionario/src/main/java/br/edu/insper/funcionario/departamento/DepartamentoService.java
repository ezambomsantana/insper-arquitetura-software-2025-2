package br.edu.insper.funcionario.departamento;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class DepartamentoService {

    public HashMap<String, Departamento> departamentos = new HashMap<>();

    public Departamento salvarDepartamento(Departamento departamento) {
        departamento.setId(UUID.randomUUID().toString());
        departamentos.put(departamento.getId(), departamento);
        return departamento;
    }

    public Departamento getDepartamento(String id) {
        return departamentos.get(id);
    }

    public Collection<Departamento> listarDepartamentos() {
        return departamentos.values();
    }

}
