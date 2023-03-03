package com.sistema.canchas.service;


import com.sistema.canchas.model.Reserva;

import java.util.List;

public interface ReservaService extends GenericService<Reserva,Long>{
    public Reserva obtenerUsuarioConPublicaciones(Long id);


    List<Reserva> buscarPorIdCliente(Long idPersona);


}
