package org.ada.moneywip.service;
import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.dto.MovimientosAhorroDTO;
import org.ada.moneywip.entity.*;
import org.ada.moneywip.repository.*;
import org.ada.moneywip.repository.exceptions.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service
public class MovimientosAhorrosService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final MovimientosAhorroRepository movimientosAhorroRepository;
    private final PersonaRepository personaRepository;
    private final ObjetivoRepository objetivoRepository;

    public MovimientosAhorrosService(MovimientosAhorroRepository movimientosAhorroRepository, PersonaRepository personaRepository, ObjetivoRepository objetivoRepository) {
        this.movimientosAhorroRepository = movimientosAhorroRepository;
        this.personaRepository = personaRepository;
        this.objetivoRepository = objetivoRepository;
    }
    public MovimientosAhorroDTO create (MovimientosAhorroDTO movimientosAhorroDTO) {
        Optional<Persona> persona = personaRepository.findById(movimientosAhorroDTO.getPersonaDni());
        if(persona.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<Objetivo> objetivo = objetivoRepository.findById(movimientosAhorroDTO.getObjetivo());
        if(objetivo.isEmpty()){
            throw new ResourceNotFoundException();
        }
        MovimientosAhorro movimientosAhorro = mapToEntity(movimientosAhorroDTO, persona.get(),objetivo.get());
        movimientosAhorro = movimientosAhorroRepository.save(movimientosAhorro);
        movimientosAhorroDTO.setId(movimientosAhorro.getId());
        return movimientosAhorroDTO;
    }

    public void delete (Integer movimientosAhorroId){
        try {
            movimientosAhorroRepository.deleteById(movimientosAhorroId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }
    public void modify (Integer movimientosAhorroId, Map<String, Object> camposAModificar){
        Optional<MovimientosAhorro> movimientosAhorro= movimientosAhorroRepository.findById(movimientosAhorroId);
        if (movimientosAhorro.isEmpty()){
            throw new ResourceNotFoundException();
        }
        MovimientosAhorro movimientosAhorroToModify= movimientosAhorro.get();
        camposAModificar.forEach((key,value) -> movimientosAhorroToModify.modifyAttributeValue(key, value));
        movimientosAhorroRepository.save(movimientosAhorroToModify);
    }
    public MovimientosAhorroDTO retrieveById (Integer movimientosAhorroId){
        Optional<MovimientosAhorro> movimientosAhorro = movimientosAhorroRepository.findById(movimientosAhorroId);
        if (movimientosAhorro.isEmpty ()){
            throw new ResourceNotFoundException();
        }
        return mapToDTO(movimientosAhorro.get());
    }


    private MovimientosAhorro mapToEntity (MovimientosAhorroDTO movimientosAhorroDTO, Persona persona, Objetivo objetivo){
        MovimientosAhorro movimientosAhorro = new MovimientosAhorro(movimientosAhorroDTO.getId(),LocalDate.parse(movimientosAhorroDTO.getFecha(),DATE_TIME_FORMATTER),
                movimientosAhorroDTO.getMonto(), persona,objetivo);
        return movimientosAhorro;
    }

    private MovimientosAhorroDTO mapToDTO (MovimientosAhorro movimientosAhorro){
        MovimientosAhorroDTO movimientosAhorroDTO = new MovimientosAhorroDTO(movimientosAhorro.getFecha().toString(),
                movimientosAhorro.getMonto());

        return movimientosAhorroDTO;
    }
}
