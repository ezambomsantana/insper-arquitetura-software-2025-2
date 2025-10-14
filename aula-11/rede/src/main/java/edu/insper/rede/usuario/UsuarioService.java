package edu.insper.rede.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario associaUsuarios(Integer idSeguidor, Integer idSeguido) {
        Usuario seguidor = usuarioRepository.findById(idSeguidor).get();
        Usuario seguido = usuarioRepository.findById(idSeguido).get();

        seguidor.getSeguidores().add(seguido);
        return usuarioRepository.save(seguidor);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
