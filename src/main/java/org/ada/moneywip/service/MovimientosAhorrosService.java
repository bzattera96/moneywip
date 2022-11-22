package org.ada.moneywip.service;

import org.ada.moneywip.repository.MovimientosAhorroRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimientosAhorrosService {

    private final MovimientosAhorroRepository movimientosAhorroRepository;

    public MovimientosAhorrosService(MovimientosAhorroRepository movimientosAhorroRepository) {
        this.movimientosAhorroRepository = movimientosAhorroRepository;
    }
}
