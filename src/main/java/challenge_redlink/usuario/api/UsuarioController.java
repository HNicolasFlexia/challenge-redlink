package challenge_redlink.usuario.api;

import challenge_redlink.usuario.api.dto.NewUsuarioDTO;
import challenge_redlink.usuario.application.CreateUsuarioUseCase;
import challenge_redlink.usuario.application.ListUsuariosUseCase;
import challenge_redlink.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private ListUsuariosUseCase listUsuariosUseCase;
    @Autowired
    private CreateUsuarioUseCase createUsuarioUseCase;

    @GetMapping
    public List<Usuario> listUsuarios(){
        return listUsuariosUseCase.listUsuarios();
    }

    @PostMapping
    public Long createUsuario(@RequestBody NewUsuarioDTO request){
        var usuario = createUsuarioUseCase
                .crearUsuario(request.getDni(), request.getName(), request.getTipoUsuario());
        return usuario.getId();
    }
}
