package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadService extends GenericService<Disponibilidad,Long>{
    Optional<Disponibilidad> porId(Long idDisponibilidad);;

    List<Disponibilidad> getDisponibilidadesPorFechaYHora(Date fecha, Integer hora, Long idCancha);
}
