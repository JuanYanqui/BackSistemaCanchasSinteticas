package com.sistema.canchas.repository;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad,Long> {


@Query(value = "SELECT * FROM disponibilidad WHERE horainicio = :fecha AND horafin = :hora AND id_cancha = :idCancha",nativeQuery = true)
        Disponibilidad getDisponibilidadesPorFechaYHora(@Param("fecha") Date fecha, @Param("hora") Integer hora, @Param("idCancha") Long idCancha);


@Query(value = "SELECT horainicio, horafin FROM disponibilidad  WHERE id_cancha= :idCancha",nativeQuery = true)
        List<Object[]> findFechasHorasByCanchaId(@Param("idCancha") Long idCancha);

   /* @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE f

@Query( value = "select * from seguimiento s where s.id_mascota = :idMascota and s.fecha_seguimiento = :fechaSeguimiento", nativeQuery = true)

   alse END FROM Disponibilidad d "
            + "WHERE d.fecha = :fecha AND d.hora = :hora AND d.cancha.idCancha = :idCancha")
    boolean existsByFechaAndHoraAndCanchaId(@Param("fecha") Date fecha, @Param("hora") Integer hora,
                                            @Param("idCancha") Long idCancha);*/
}
