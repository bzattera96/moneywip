package org.ada.moneywip.service;

import org.ada.moneywip.repository.ObjetivoRepository;
import org.springframework.stereotype.Service;

@Service
public class ObjetivoService {
    private final ObjetivoRepository objetivoRepository;

    public ObjetivoService(ObjetivoRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }
}