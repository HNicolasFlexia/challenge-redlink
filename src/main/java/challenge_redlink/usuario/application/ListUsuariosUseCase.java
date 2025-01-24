package challenge_redlink.usuario.application;

import challenge_redlink.usuario.domain.Usuario;
import challenge_redlink.usuario.domain.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsuariosUseCase {
    private final UsuarioRepository usuarioRepository;

    public ListUsuariosUseCase(UsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    public List<Usuario> listUsuarios(){
        return usuarioRepository.findAll();
    }
}
