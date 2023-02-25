package com.sistema.canchas.repository;

import com.sistema.canchas.model.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad,Long> {

        @Query("SELECT d FROM Disponibilidad d WHERE d.fecha = :fecha AND d.hora = :hora AND d.cancha.idCancha = :idCancha")
        List<Disponibilidad> getDisponibilidadesPorFechaYHora(@Param("fecha") Date fecha, @Param("hora") Integer hora, @Param("idCancha") Long idCancha);
}
