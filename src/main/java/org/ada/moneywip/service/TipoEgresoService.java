package org.ada.moneywip.service;

import org.ada.moneywip.repository.TipoEgresoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEgresoService {

    private final TipoEgresoRepository tipoEgresoRepository;

    public TipoEgresoService(TipoEgresoRepository tipoEgresoRepository) {
        this.tipoEgresoRepository = tipoEgresoRepository;
    }
}
