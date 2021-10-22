package br.com.godoydev.PScblab.repository;

import br.com.godoydev.PScblab.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String login);
}
