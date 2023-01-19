package org.ada.moneywip.service;

import org.ada.moneywip.dto.AsignacionObjetivoDTO;
import org.ada.moneywip.entity.AsignacionObjetivo;
import org.ada.moneywip.entity.Objetivo;
import org.ada.moneywip.entity.Persona;
import org.ada.moneywip.repository.AsignacionObjetivoRepository;
import org.ada.moneywip.repository.exceptions.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AsignacionObjetivoService {

    private final AsignacionObjetivoRepository asignacionObjetivoRepository;

    public AsignacionObjetivoService(AsignacionObjetivoRepository asignacionObjetivoRepository) {
        this.asignacionObjetivoRepository = asignacionObjetivoRepository;
    }
    public AsignacionObjetivoDTO create (AsignacionObjetivoDTO asignacionObjetivoDTO) {
        Optional<AsignacionObjetivo> asignacionObjetivo = asignacionObjetivoRepository.findById(asignacionObjetivoDTO.getId());
        if (asignacionObjetivo.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return asignacionObjetivoDTO;
    }

        private AsignacionObjetivo mapToEntity (AsignacionObjetivoDTO asignacionObjetivoDTO, Objetivo objetivo, Persona persona){
            AsignacionObjetivo asignacionObjetivo = new AsignacionObjetivo(asignacionObjetivoDTO.getId(), asignacionObjetivoDTO.getActivo(),
                    objetivo, persona);
            return asignacionObjetivo;
        }

        private AsignacionObjetivoDTO mapToDTO (AsignacionObjetivo asignacionObjetivo){
            AsignacionObjetivoDTO asignacionObjetivoDTO = new AsignacionObjetivoDTO(asignacionObjetivo.getActivo());
            return asignacionObjetivoDTO;
        }

    public void delete (Integer asignacionObjetivoId){
        try {
            asignacionObjetivoRepository.deleteById(asignacionObjetivoId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }

    public void modify (Integer asignacionObjetivoId, Map<String, Object> camposAModificar){
        Optional<AsignacionObjetivo> asignacionObjetivo= asignacionObjetivoRepository.findById(asignacionObjetivoId);
        if (asignacionObjetivo.isEmpty()){
            throw new ResourceNotFoundException();
        }
        AsignacionObjetivo asignacionObjetivoToModify= asignacionObjetivo.get();
        camposAModificar.forEach((key,value) -> asignacionObjetivoToModify.modifyAttributeValue(key, value));
        asignacionObjetivoRepository.save(asignacionObjetivoToModify);
    }

    public AsignacionObjetivoDTO retrieveById (Integer asignacionObjetivoId){
        Optional<AsignacionObjetivo> asignacionObjetivo = asignacionObjetivoRepository.findById(asignacionObjetivoId);
        if (asignacionObjetivo.isEmpty ()){
            throw new ResourceNotFoundException();
        }
        return mapToDTO(asignacionObjetivo.get());
    }

}
