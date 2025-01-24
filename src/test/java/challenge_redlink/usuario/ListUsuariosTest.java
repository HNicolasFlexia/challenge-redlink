package challenge_redlink.usuario;

import challenge_redlink.usuario.api.UsuarioController;
import challenge_redlink.usuario.domain.TipoUsuario;
import challenge_redlink.usuario.domain.Usuario;
import challenge_redlink.usuario.domain.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListUsuariosTest {
    @Autowired
    private UsuarioController controller;
    @Autowired
    private UsuarioRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
        var user1 = new Usuario("11111111", "Alan", TipoUsuario.ADMINISTRADOR);
        var user2 = new Usuario("22222222", "Matias", TipoUsuario.EMPLEADO);
        var user3 = new Usuario("33333333", "Javier", TipoUsuario.EMPLEADO);
        repository.saveAll(List.of(user1,user2,user3));
    }

    @Test
    void listUsuarios(){
        var usuarios = controller.listUsuarios();
        Assertions.assertNotNull(usuarios);
    }
}
