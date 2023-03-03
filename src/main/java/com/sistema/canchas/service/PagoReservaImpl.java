package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoReserva;
import com.sistema.canchas.model.Reserva;
import com.sistema.canchas.model.ResourceNotFoundException;
import com.sistema.canchas.repository.DisponibilidadRepository;
import com.sistema.canchas.repository.PagoReservaRepository;
import com.sistema.canchas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoReservaImpl extends GenericServiceImpl<PagoReserva,Long> implements PagoReservaService{
    @Autowired
    PagoReservaRepository pagoReservaRepository;

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    @Autowired
    ReservaRepository reservaRepository;
    @Override
    public CrudRepository<PagoReserva, Long> getDao() {
        return pagoReservaRepository;
    }

    @Override
    public Optional<PagoReserva> porId(Long idPagoReserva) {
        return pagoReservaRepository.findById(idPagoReserva);
    }

    @Override
    public List<PagoReserva> findByReservaclienteIdPersona(Long idPersona) {
        return pagoReservaRepository.findByReservaClienteIdPersona(idPersona);
    }


    public void deletePagoReserva(Long idPagoReserva) {
        PagoReserva pagoReserva = pagoReservaRepository.findById(idPagoReserva)
                .orElseThrow(() -> new ResourceNotFoundException("PagoReserva not found with id " + idPagoReserva));
        Reserva reserva = pagoReserva.getReserva();

        reserva.getDisponibilidades().forEach(disponibilidad -> disponibilidadRepository.delete(disponibilidad));
        // Eliminar la reserva
        reservaRepository.delete(reserva);
        // Eliminar el pago de la reserva
        pagoReservaRepository.delete(pagoReserva);
    }

    public List<PagoReserva> obtenerPagosPorEstablecimiento(Long idEstablecimiento) {
        return pagoReservaRepository.findByReservaDisponibilidadesCanchaEstablecimientoIdEstablecimiento(idEstablecimiento);
    }
}
