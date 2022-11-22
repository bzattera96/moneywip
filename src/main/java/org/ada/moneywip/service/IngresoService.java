package org.ada.moneywip.service;

import org.ada.moneywip.repository.IngresoRepository;
import org.springframework.stereotype.Service;

@Service

public class IngresoService {

    private final IngresoRepository ingresoRepository;

    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }
}
