package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadService extends GenericService<Disponibilidad,Long>{
    Optional<Disponibilidad> porId(Long idDisponibilidad);;

    boolean existsDisponibilidadByFechaAndHoraAndCanchaId(Date fecha, Integer hora, Long idCancha);

    List<Object[]> getFechasHorasByCanchaId(Long idCancha);

   /* List<Disponibilidad> getDisponibilidadesPorFechaYHora(Date fecha, Integer hora, Long idCancha);

    public Boolean verificarDisponibilidad(Date fecha, Integer hora, Long idCancha);*/
}


