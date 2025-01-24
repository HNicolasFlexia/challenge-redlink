package challenge_redlink.prestamo.application;
import challenge_redlink.prestamo.domain.Prestamo;
import challenge_redlink.prestamo.domain.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GetPrestamosVisualizadosUseCase {
    private final PrestamoRepository prestamoRepository;

    public GetPrestamosVisualizadosUseCase(PrestamoRepository prestamoRepository){this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> getPrestamosVisualizados(){
        return prestamoRepository.findAllByFechaVisualizacionAfterAndPrestamoVisualizado(LocalDate.now().atStartOfDay(),true);
    }
}
