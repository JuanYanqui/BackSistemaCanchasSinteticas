package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.model.PagoReserva;
import com.sistema.canchas.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface PagoReservaService extends GenericService<PagoReserva,Long>{
    Optional<PagoReserva> porId(Long idPagoReserva);;;

    List<PagoReserva> findByReservaclienteIdPersona(Long idPersona);

    void deletePagoReserva(Long idPagoReserva);

    List<PagoReserva> obtenerPagosPorEstablecimiento(Long idEstablecimieto);
}
