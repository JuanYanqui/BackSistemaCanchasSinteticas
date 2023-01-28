package com.sistema.canchas.service;

import com.sistema.canchas.model.Usuario;

import java.util.Optional;

public interface UsuarioService extends GenericService <Usuario, Long>{
    Usuario login (String username, String password);

    boolean porUsername(String username);


    Optional<Usuario> porId(Long idUsuario);

}
