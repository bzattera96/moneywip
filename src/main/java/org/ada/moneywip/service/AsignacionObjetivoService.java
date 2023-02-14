package org.ada.moneywip.service;

import org.ada.moneywip.dto.AsignacionObjetivoDTO;
import org.ada.moneywip.entity.AsignacionObjetivo;
import org.ada.moneywip.entity.MovimientosAhorro;
import org.ada.moneywip.entity.Objetivo;
import org.ada.moneywip.entity.Persona;
import org.ada.moneywip.repository.AsignacionObjetivoRepository;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.ObjetivoRepository;
import org.ada.moneywip.repository.PersonaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AsignacionObjetivoService {

    private final AsignacionObjetivoRepository asignacionObjetivoRepository;
    private final PersonaRepository personaRepository;
    private final ObjetivoRepository objetivoRepository;

    public AsignacionObjetivoService(AsignacionObjetivoRepository asignacionObjetivoRepository, PersonaRepository personaRepository, ObjetivoRepository objetivoRepository) {
        this.asignacionObjetivoRepository = asignacionObjetivoRepository;
        this.personaRepository = personaRepository;
        this.objetivoRepository = objetivoRepository;
    }

    public AsignacionObjetivoDTO create (AsignacionObjetivoDTO asignacionObjetivoDTO) {
        Optional<Persona> persona = personaRepository.findById(asignacionObjetivoDTO.getIdPersona());
        if(persona.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<Objetivo> objetivo = objetivoRepository.findById(asignacionObjetivoDTO.getIdObjetivo());
        if(objetivo.isEmpty()){
            throw new ResourceNotFoundException();
        }
        AsignacionObjetivo asignacionObjetivo = mapToEntity(asignacionObjetivoDTO, objetivo.get(), persona.get());
        asignacionObjetivo = asignacionObjetivoRepository.save(asignacionObjetivo);
        asignacionObjetivoDTO.setId(asignacionObjetivo.getId());
        return asignacionObjetivoDTO;
    }

        private AsignacionObjetivo mapToEntity (AsignacionObjetivoDTO asignacionObjetivoDTO, Objetivo objetivo, Persona persona){
            AsignacionObjetivo asignacionObjetivo = new AsignacionObjetivo(asignacionObjetivoDTO.getId(), asignacionObjetivoDTO.getActivo(), objetivo, persona);
            return asignacionObjetivo;
        }

        private AsignacionObjetivoDTO mapToDTO (AsignacionObjetivo asignacionObjetivo){
            AsignacionObjetivoDTO asignacionObjetivoDTO = new AsignacionObjetivoDTO(asignacionObjetivo.getId(), asignacionObjetivo.getActivo(), asignacionObjetivo.getPersona().getDni(), asignacionObjetivo.getObjetivo().getId());
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
