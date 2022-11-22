package org.ada.moneywip.service;

import org.ada.moneywip.repository.AsignacionObjetivoRepository;
import org.springframework.stereotype.Service;

@Service
public class AsignacionObjetivoService {

    private final AsignacionObjetivoRepository asignacionObjetivoRepository;

    public AsignacionObjetivoService(AsignacionObjetivoRepository asignacionObjetivoRepository) {
        this.asignacionObjetivoRepository = asignacionObjetivoRepository;
    }
}
