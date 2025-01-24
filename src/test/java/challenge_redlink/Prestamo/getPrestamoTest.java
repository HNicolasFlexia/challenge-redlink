package challenge_redlink.Prestamo;

import challenge_redlink.prestamo.api.PrestamoController;
import challenge_redlink.prestamo.api.dto.OfertaPrestamoDTO;
import challenge_redlink.prestamo.domain.Prestamo;
import challenge_redlink.prestamo.domain.PrestamoRepository;
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
public class getPrestamoTest {
    @Autowired
    private PrestamoController controller;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setup() {
        usuarioRepository.deleteAll();
        var user1 = new Usuario("11111111", "Alan", TipoUsuario.ADMINISTRADOR);
        var user2 = new Usuario("22222222", "Matias", TipoUsuario.EMPLEADO);
        var user3 = new Usuario("33333333", "Javier", TipoUsuario.EMPLEADO);
        usuarioRepository.saveAll(List.of(user1,user2,user3));

        prestamoRepository.deleteAll();
        var prestamo1 = new Prestamo(1000000L,user3.getDni());
        prestamoRepository.save(prestamo1);
    }

    @Test
    void usuarioInvalido(){
        OfertaPrestamoDTO prestamo = controller.getPrestamo("44444444");
        Assertions.assertEquals(0L, prestamo.getMonto());
        Assertions.assertEquals("El dni del usuario ingresado no corresponde con un usuario registrado en la base de datos.",prestamo.getDescripcion());
    }

    @Test
    void tipoUsuarioInvalido(){
        OfertaPrestamoDTO prestamo = controller.getPrestamo("11111111");
        Assertions.assertEquals(0L, prestamo.getMonto());
        Assertions.assertEquals("El usuario no es de tipo EMPLEADO. No tiene acceso a prestamos.",prestamo.getDescripcion());
    }

    @Test
    void usuarioSinPrestamos(){
        OfertaPrestamoDTO prestamo = controller.getPrestamo("22222222");
        Assertions.assertEquals(0L, prestamo.getMonto());
        Assertions.assertEquals("El usuario es de tipo EMPLEADO, pero no cuenta con prestamos disponibles.",prestamo.getDescripcion());
    }

    @Test
    void usuarioConPrestamo(){
        OfertaPrestamoDTO prestamo = controller.getPrestamo("33333333");
        Assertions.assertEquals(1000000L, prestamo.getMonto());
        Assertions.assertEquals("El usuario es de tipo EMPLEADO y cuenta con una oferta de prestamo disponible",prestamo.getDescripcion());
    }
}
