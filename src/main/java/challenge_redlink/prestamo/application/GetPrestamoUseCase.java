package challenge_redlink.prestamo.application;

import challenge_redlink.prestamo.api.dto.OfertaPrestamoDTO;
import challenge_redlink.prestamo.domain.Prestamo;
import challenge_redlink.prestamo.domain.PrestamoRepository;
import challenge_redlink.usuario.domain.TipoUsuario;
import challenge_redlink.usuario.domain.Usuario;
import challenge_redlink.usuario.domain.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GetPrestamoUseCase {
    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;

    public GetPrestamoUseCase(PrestamoRepository prestamoRepository, UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        usuarioRepository.deleteAll();
        var user1 = new Usuario("11111111", "Alan", TipoUsuario.ADMINISTRADOR);
        var user2 = new Usuario("22222222", "Matias", TipoUsuario.EMPLEADO);
        var user3 = new Usuario("33333333", "Javier", TipoUsuario.EMPLEADO);
        var user4 = new Usuario("44444444", "Roberto", TipoUsuario.EMPLEADO);
        var user5 = new Usuario("55555555", "Elias", TipoUsuario.EMPLEADO);
        var user6 = new Usuario("66666666", "Luis", TipoUsuario.EMPLEADO);
        var user7 = new Usuario("77777777", "Lucas", TipoUsuario.EMPLEADO);
        var user8 = new Usuario("88888888", "Alejandro", TipoUsuario.EMPLEADO);
        usuarioRepository.saveAll(List.of(user1,user2,user3,user5,user6,user7,user8));
        this.prestamoRepository = prestamoRepository;
        prestamoRepository.deleteAll();
        var prestamo1 = new Prestamo(1000000L,user3.getDni());
        var prestamo2 = new Prestamo(100000L,user5.getDni());
        var prestamo3 = new Prestamo(2000000L,user6.getDni());
        var prestamo4 = new Prestamo(300000L,user7.getDni());
        var prestamo5 = new Prestamo(60000L,user8.getDni());
        prestamoRepository.saveAll(List.of(prestamo1,prestamo2,prestamo3,prestamo4,prestamo5));
    }

    public OfertaPrestamoDTO getPrestamo(String usuariodni){

        Usuario usuario = usuarioRepository.findUsuarioBydni(usuariodni);
        Long monto = 0L;
        String descripcion;

        if(usuario == null){
            descripcion = "El dni del usuario ingresado no corresponde con un usuario registrado en la base de datos.";
            return new OfertaPrestamoDTO(monto,descripcion);
        }

        if(!TipoUsuario.EMPLEADO.equals(usuario.getTipoUsuario())){
            descripcion = "El usuario no es de tipo EMPLEADO. No tiene acceso a prestamos.";
            return new OfertaPrestamoDTO(monto,descripcion);
        }

        Prestamo prestamo = prestamoRepository.findByUsuariodni(usuario.getDni());

        if (prestamo == null) {
            descripcion = "El usuario es de tipo EMPLEADO, pero no cuenta con prestamos disponibles.";
        } else {
            prestamo.prestamoVisualizado(LocalDateTime.now());
            prestamoRepository.save(prestamo);
            monto = prestamo.getMonto();
            descripcion = "El usuario es de tipo EMPLEADO y cuenta con una oferta de prestamo disponible";
        }

        return new OfertaPrestamoDTO(monto,descripcion);
    }
}
