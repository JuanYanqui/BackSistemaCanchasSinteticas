package com.sistema.canchas.repository;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
    Establecimiento findByRuc(String ruc);
}
