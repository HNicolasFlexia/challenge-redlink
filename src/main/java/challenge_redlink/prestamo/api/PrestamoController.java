package challenge_redlink.prestamo.api;

import challenge_redlink.prestamo.api.dto.NewPrestamoDTO;
import challenge_redlink.prestamo.api.dto.OfertaPrestamoDTO;
import challenge_redlink.prestamo.application.CreatePrestamoUseCase;
import challenge_redlink.prestamo.application.GetPrestamoUseCase;
import challenge_redlink.prestamo.application.GetPrestamosVisualizadosUseCase;
import challenge_redlink.prestamo.domain.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PrestamoController {
    @Autowired
    private CreatePrestamoUseCase createPrestamoUseCase;
    @Autowired
    private GetPrestamoUseCase getPrestamoUseCase;
    @Autowired
    private GetPrestamosVisualizadosUseCase getPrestamosVisualizadosUseCase;

    @GetMapping("/prestamo/{usuario-dni}")
    public OfertaPrestamoDTO getPrestamo(@PathVariable("usuario-dni") String usuariodni){
        return getPrestamoUseCase.getPrestamo(usuariodni);
    }

    @GetMapping("prestamos/visualizados")
    public List<Prestamo> getPrestamosVisualizados(){
        return getPrestamosVisualizadosUseCase.getPrestamosVisualizados();
    }

    @PostMapping
    public Long createPrestamo(@RequestBody NewPrestamoDTO request){
        var prestamo = createPrestamoUseCase
                .createPrestamo(request.getMonto(), request.getUsuariodni());
        return prestamo.getId();
    }
}
