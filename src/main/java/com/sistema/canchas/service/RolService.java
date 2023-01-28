package com.sistema.canchas.service;

import com.sistema.canchas.model.Rol;

import java.util.Optional;

public interface RolService extends GenericService <Rol, Long>{
    Rol porNombre(String nombre);
    Optional<Rol> porId(Long idRol);
}
