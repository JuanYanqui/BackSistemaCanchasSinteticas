package com.sistema.canchas.repository;

import com.sistema.canchas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsername(String username);

}
