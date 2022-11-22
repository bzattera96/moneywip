package org.ada.moneywip.service;

import org.ada.moneywip.repository.EgresoRepository;
import org.springframework.stereotype.Service;

@Service
public class EgresoService {

   private final EgresoRepository egresoRepository;

    public EgresoService(EgresoRepository egresoRepository) {
        this.egresoRepository = egresoRepository;
    }
}
