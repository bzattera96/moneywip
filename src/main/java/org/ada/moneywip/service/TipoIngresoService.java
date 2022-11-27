package org.ada.moneywip.service;

import org.ada.moneywip.repository.TipoIngresoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoIngresoService {
    private final TipoIngresoRepository tipoIngresoRepository;

    public TipoIngresoService(TipoIngresoRepository tipoIngresoRepository) {
        this.tipoIngresoRepository = tipoIngresoRepository;
    }


}