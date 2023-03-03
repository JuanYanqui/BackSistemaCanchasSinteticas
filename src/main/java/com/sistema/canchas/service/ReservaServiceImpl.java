package com.sistema.canchas.service;

import com.sistema.canchas.model.Reserva;
import com.sistema.canchas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl extends GenericServiceImpl<Reserva,Long>implements ReservaService{
    @Autowired
    ReservaRepository reservaRepository;
    @Override
    public CrudRepository<Reserva, Long> getDao() {
        return reservaRepository;
    }

    public Reserva obtenerUsuarioConPublicaciones(Long id) {
        return reservaRepository.findById(id)
                .map(usuario -> {
                    usuario.getDisponibilidades().size(); // Accede a la lista de publicaciones para forzar la carga desde la base de datos
                    return usuario;
                })
                .orElseThrow(() -> null);
    }

    @Override
    public List<Reserva> buscarPorIdCliente(Long idPersona) {
        return reservaRepository.findByClienteId(idPersona);
    }





}
