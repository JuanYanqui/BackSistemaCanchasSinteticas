package com.sistema.canchas.repository;

import com.sistema.canchas.model.PagoReserva;
import com.sistema.canchas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoReservaRepository extends JpaRepository<PagoReserva,Long> {

    /*@Query("SELECT p FROM PagoReserva p WHERE p.reserva.idReserva = :idReserva")
    List<PagoReserva> findBypagoId(@Param("idReserva") Long idReserva);*/

    List<PagoReserva> findByReservaClienteIdPersona(@Param("idPersona") Long idPersona);

   /* List<PagoReserva> findByReservaclienteIdPersona(@Param("idPersona") Long idPersona);*/

    void deleteByReservaIdReserva(Long idReserva);

    List<PagoReserva> findByReservaDisponibilidadesCanchaEstablecimientoIdEstablecimiento(Long idEstablecimiento);
}
