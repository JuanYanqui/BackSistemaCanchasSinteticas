package com.sistema.canchas.service;

import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.repository.DisponibilidadRepository;
import com.sistema.canchas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadServiceImpl extends GenericServiceImpl<Disponibilidad,Long> implements DisponibilidadService{
    @Autowired
    DisponibilidadRepository disponibilidadRepository;
    private ReservaRepository reservaRepository;
    @Override
    public CrudRepository<Disponibilidad, Long> getDao() {
        return disponibilidadRepository;
    }

    @Override
    public Optional<Disponibilidad> porId(Long idDisponibilidad) {

        return disponibilidadRepository.findById(idDisponibilidad);
    }

  /*  @Override
    public List<Disponibilidad> getDisponibilidadesPorFechaYHora(Date fecha, Integer hora, Long idCancha) {
        return null;
    }

    public Boolean verificarDisponibilidad(Date fecha, Integer hora, Long idCancha) {
        return disponibilidadRepository.existsByFechaAndHoraAndCanchaId(fecha, hora, idCancha);
    }
*/

    public boolean existsDisponibilidadByFechaAndHoraAndCanchaId(Date fecha, Integer hora, Long idCancha) {
        if(disponibilidadRepository.getDisponibilidadesPorFechaYHora(fecha,hora, idCancha)!=null){
            return  true;
        }else {
            return false;
        }
    }

    public List<Object[]> getFechasHorasByCanchaId(Long idCancha) {
        return disponibilidadRepository.findFechasHorasByCanchaId(idCancha);
    }


}
