package com.sistema.canchas.repository;

import com.sistema.canchas.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CanchaRepository extends JpaRepository<Cancha,Long> {
    List<Cancha> findByEstablecimientoIdEstablecimiento(Long idEstablecimiento);


}
