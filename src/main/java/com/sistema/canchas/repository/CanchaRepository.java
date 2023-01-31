package com.sistema.canchas.repository;

import com.sistema.canchas.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanchaRepository extends JpaRepository<Cancha,Long> {
}
