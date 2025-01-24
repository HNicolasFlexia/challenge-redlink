package challenge_redlink.Prestamo;

import challenge_redlink.prestamo.api.PrestamoController;
import challenge_redlink.prestamo.api.dto.NewPrestamoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreatePrestamoTest {
    @Autowired
    private PrestamoController controller;

    @Test
    void ok(){
        var id = controller.createPrestamo(
                new NewPrestamoDTO(1000000L,"11111111")
        );
        Assertions.assertNotNull(id);
    }
}
