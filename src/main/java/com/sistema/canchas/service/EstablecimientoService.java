package com.sistema.canchas.service;

import com.sistema.canchas.model.Establecimiento;

public interface EstablecimientoService extends GenericService<Establecimiento,Long>{
    Establecimiento Ruc(String ruc);
}
