package br.edu.insper.cinema.sessao.model;

import br.edu.insper.cinema.filme.Filme;
import br.edu.insper.cinema.ingresso.Ingresso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String horario;
    private String sala;

    private Integer totalIngressos;

    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;


    @JsonIgnore
    @OneToMany(mappedBy = "sessao")
    private List<Ingresso> ingressos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Integer getTotalIngressos() {
        return totalIngressos;
    }

    public void setTotalIngressos(Integer totalIngressos) {
        this.totalIngressos = totalIngressos;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

}
