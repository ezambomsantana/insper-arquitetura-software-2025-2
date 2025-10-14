package edu.insper.rede.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_usuario",
            joinColumns = @JoinColumn(name = "id_seguidor"),
            inverseJoinColumns = @JoinColumn(name = "id_seguido")
    )
    private List<Usuario> seguidores;

    @JsonIgnore
    @ManyToMany(mappedBy = "seguidores")
    private List<Usuario> seguem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public List<Usuario> getSeguem() {
        return seguem;
    }

    public void setSeguem(List<Usuario> seguem) {
        this.seguem = seguem;
    }
}
