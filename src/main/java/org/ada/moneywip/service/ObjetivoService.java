package org.ada.moneywip.service;

import org.ada.moneywip.dto.ObjetivoDTO;
import org.ada.moneywip.entity.Objetivo;
import org.ada.moneywip.exceptions.ExistingResourceException;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.ObjetivoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service
public class ObjetivoService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final ObjetivoRepository objetivoRepository;

    public ObjetivoService(ObjetivoRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }

    public ObjetivoDTO create (ObjetivoDTO objetivoDTO) {
        Objetivo objetivo = mapToEntity(objetivoDTO);
        checkForExistingObjetivo(objetivo.getObjetivo());
        objetivo = objetivoRepository.save(objetivo);

        return objetivoDTO;
    }

    public ObjetivoDTO retrieveByObjetivoId(Integer objetivoId) {
    Optional<Objetivo> objetivo = objetivoRepository.findById(objetivoId);
        if (objetivo.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(objetivo.get());
    }

    public void delete(Integer objetivoId) {
        try {
            objetivoRepository.deleteById(objetivoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void modify(Integer objetivoId, Map<String,Object> camposAModificar) {
        Optional<Objetivo> objetivo = objetivoRepository.findById(objetivoId);
        if (objetivo.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Objetivo objetivoAModificar = objetivo.get();
        camposAModificar.forEach((key, value) -> objetivoAModificar.modifyAttributeValue(key, value));
        objetivoRepository.save(objetivoAModificar);
    }

    private void checkForExistingObjetivo(String objetivo) {
        if (objetivoRepository.existsByObjetivo(objetivo)) {
            throw new ExistingResourceException();
        }
    }

    private Objetivo mapToEntity(ObjetivoDTO objetivoDTO) {
        Objetivo objetivo = new Objetivo(objetivoDTO.getId(), objetivoDTO.getObjetivo(), LocalDate.parse(objetivoDTO.getFechaObj(), DATE_TIME_FORMATTER), objetivoDTO.getMonto(), objetivoDTO.getActivo());
        return objetivo;
    }

    private ObjetivoDTO mapToDTO(Objetivo objetivo) {
        ObjetivoDTO objetivoDTO = new ObjetivoDTO(objetivo.getObjetivo(), objetivo.getFechaObj().toString(), objetivo.getMonto(), objetivo.getActivo());
        return objetivoDTO;
    }

}