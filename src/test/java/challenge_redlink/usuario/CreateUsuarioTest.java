package challenge_redlink.usuario;

import challenge_redlink.usuario.api.dto.NewUsuarioDTO;
import challenge_redlink.usuario.api.UsuarioController;
import challenge_redlink.usuario.domain.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateUsuarioTest {
    @Autowired
    private UsuarioController controller;

    @Test
    void crearUsuario() {
        var id = controller.createUsuario(
                new NewUsuarioDTO("1234567","Pedro", TipoUsuario.EMPLEADO)
        );
        Assertions.assertNotNull(id);
    }
}
