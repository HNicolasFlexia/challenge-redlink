package challenge_redlink.prestamo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    Prestamo findByUsuariodni(String usuariodni);
    List<Prestamo> findAllByFechaVisualizacionAfterAndPrestamoVisualizado(LocalDateTime fechaVisualizacion, boolean prestamoVisualizado );
}
