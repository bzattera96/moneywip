package org.ada.moneywip.service;

import org.ada.moneywip.dto.EgresoDTO;
import org.ada.moneywip.entity.*;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.EgresoRepository;
import org.ada.moneywip.repository.PersonaRepository;
import org.ada.moneywip.repository.TipoEgresoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service
public class EgresoService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final EgresoRepository egresoRepository;
    private final PersonaRepository personaRepository;
    private final TipoEgresoRepository tipoEgresoRepository;

    public EgresoService(EgresoRepository egresoRepository, PersonaRepository personaRepository, TipoEgresoRepository tipoEgresoRepository) {
        this.egresoRepository = egresoRepository;
        this.personaRepository = personaRepository;
        this.tipoEgresoRepository = tipoEgresoRepository;
    }

    public EgresoDTO create (EgresoDTO egresoDTO) {
        Optional<Persona> persona = personaRepository.findById(egresoDTO.getPersonaDni());
        if(persona.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<TipoEgreso> tipoEgreso = tipoEgresoRepository.findById(egresoDTO.getTipoEgreso());
        if(tipoEgreso.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Egreso egreso = mapToEntity(egresoDTO, persona.get(),tipoEgreso.get());
        egreso = egresoRepository.save(egreso);
        egresoDTO.setId(egreso.getId());
        return egresoDTO;
    }

    public void delete (Integer egresoId){
        try {
            egresoRepository.deleteById(egresoId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }

    public void modify (Integer egresoId, Map<String, Object> camposAModificar){
        Optional<Egreso> egreso= egresoRepository.findById(egresoId);
        if (egreso.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Egreso egresoToModify= egreso.get();
        camposAModificar.forEach((key,value) -> egresoToModify.modifyAttributeValue(key, value));
        egresoRepository.save(egresoToModify);
    }

    public EgresoDTO retrieveById (Integer egresoId){
        Optional<Egreso> egreso = egresoRepository.findById(egresoId);
        if (egreso.isEmpty ()){
            throw new ResourceNotFoundException();
        }
        return mapToDTO(egreso.get());
    }

    private Egreso mapToEntity (EgresoDTO egresoDTO, Persona persona, TipoEgreso tipoEgreso){
        Egreso egreso = new Egreso(LocalDate.parse(egresoDTO.getFecha(),DATE_TIME_FORMATTER),
                egresoDTO.getMonto(), tipoEgreso, persona);
        return egreso;
    }

    private EgresoDTO mapToDTO (Egreso egreso){
        EgresoDTO egresoDTO = new EgresoDTO(egreso.getId(),egreso.getFecha().toString(), egreso.getMonto(), egreso.getTipoEgreso().getId(), egreso.getPersona().getDni());
        return egresoDTO;
    }
}