package org.ada.moneywip.service;

import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.entity.Ingreso;
import org.ada.moneywip.entity.Persona;
import org.ada.moneywip.entity.TipoIngreso;
import org.ada.moneywip.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.IngresoRepository;
import org.ada.moneywip.repository.PersonaRepository;
import org.ada.moneywip.repository.TipoIngresoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service

public class IngresoService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final IngresoRepository ingresoRepository;
    private final PersonaRepository personaRepository;
    private final TipoIngresoRepository tipoIngresoRepository;

    public IngresoService(IngresoRepository ingresoRepository, PersonaRepository personaRepository,
                          TipoIngresoRepository tipoIngresoRepository) {
        this.ingresoRepository = ingresoRepository;
        this.personaRepository = personaRepository;
        this.tipoIngresoRepository = tipoIngresoRepository;
    }

    public IngresoDTO create (IngresoDTO ingresoDTO, String personaDni, Integer tipoIngresoId ) {
        Optional<Persona> persona = personaRepository.findById(personaDni);
        if(persona.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<TipoIngreso> tipoIngreso = tipoIngresoRepository.findById(tipoIngresoId);
        if(tipoIngreso.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Ingreso ingreso = mapToEntity(ingresoDTO, persona.get(),tipoIngreso.get());
        ingreso = ingresoRepository.save(ingreso);
        ingresoDTO.setId(ingreso.getId());
     return ingresoDTO;
    }

    public void delete (Integer ingresoId){
        try {
            ingresoRepository.deleteById(ingresoId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }

    public void modify (Integer ingresoId, Map<String, Object> camposAModificar){
        Optional<Ingreso> ingreso= ingresoRepository.findById(ingresoId);
        if (ingreso.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Ingreso ingresoToModify= ingreso.get();
        camposAModificar.forEach((key,value) -> ingresoToModify.modifyAttributeValue(key, value));
        ingresoRepository.save(ingresoToModify);
    }

    public IngresoDTO retrieveById (String dni){
        Optional<Ingreso> ingreso = ingresoRepository.findByPersona(dni);
        if (ingreso.isEmpty ()){
          throw new ResourceNotFoundException();
        }
        return mapToDTO(ingreso.get());
    }


    private Ingreso mapToEntity (IngresoDTO ingresoDTO, Persona persona, TipoIngreso tipoIngreso){
        Ingreso ingreso = new Ingreso( LocalDate.parse(ingresoDTO.getFecha(),DATE_TIME_FORMATTER),
                ingresoDTO.getMonto(), tipoIngreso,persona);
        return ingreso;
    }

    private IngresoDTO mapToDTO (Ingreso ingreso){
        IngresoDTO ingresoDTO = new IngresoDTO(ingreso.getId(),ingreso.getFecha().toString(), ingreso.getMonto());
        return ingresoDTO;
    }



}

