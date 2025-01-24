package challenge_redlink.prestamo.application;

import challenge_redlink.prestamo.domain.Prestamo;
import challenge_redlink.prestamo.domain.PrestamoRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePrestamoUseCase {
    private final PrestamoRepository prestamoRepository;

    public CreatePrestamoUseCase(PrestamoRepository prestamoRepository){
        this.prestamoRepository = prestamoRepository;
    }

    public Prestamo createPrestamo(Long monto, String usuariodni) {
        var prestamo = new Prestamo(monto,usuariodni);
        return prestamoRepository.save(prestamo);
    }
}
