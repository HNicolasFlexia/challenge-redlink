package challenge_redlink.usuario.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioBydni(String usuariodni);
}
