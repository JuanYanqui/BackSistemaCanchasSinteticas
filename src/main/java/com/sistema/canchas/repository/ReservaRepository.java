package com.sistema.canchas.repository;

import com.sistema.canchas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {

    /*@Query(value = "SELECT * FROM reserva  WHERE id_persona = : idPersona", nativeQuery = true)
    List<Reserva> findByClienteId(@Param("idPersona") Long idPersona);
*/

    @Query("SELECT r FROM Reserva r WHERE r.cliente.idPersona = :idPersona")
    List<Reserva> findByClienteId(@Param("idPersona") Long idPersona);
}
