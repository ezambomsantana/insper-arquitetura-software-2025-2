package edu.insper.rede.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{idSeguidor}/usuario/{idSeguido}")
    public Usuario associarUsuarios(@PathVariable Integer idSeguidor,
                                    @PathVariable Integer idSeguido) {
        return usuarioService.associaUsuarios(idSeguidor, idSeguido);
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.listarUsuarios();
    }

}
