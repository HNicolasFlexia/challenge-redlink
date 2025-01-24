package challenge_redlink.usuario.application;

import challenge_redlink.usuario.domain.TipoUsuario;
import challenge_redlink.usuario.domain.Usuario;
import challenge_redlink.usuario.domain.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CreateUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    public Usuario crearUsuario(String dni, String nombre, TipoUsuario tipoUsuario){
        var usuario = new Usuario(dni,nombre,tipoUsuario);
        return usuarioRepository.save(usuario);
    }
}
