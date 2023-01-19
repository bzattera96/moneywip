package org.ada.moneywip.service;

import org.ada.moneywip.dto.PersonaDTO;
import org.ada.moneywip.entity.Persona;
import org.ada.moneywip.repository.exceptions.ExistingResourceException;
import org.ada.moneywip.repository.exceptions.ResourceNotFoundException;
import org.ada.moneywip.repository.PersonaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public PersonaDTO create (PersonaDTO personaDTO) {
        Persona persona = mapToEntity(personaDTO);
        checkForExistingPerson(persona.getDni());
        persona = personaRepository.save(persona);
        return personaDTO;
    }

    public PersonaDTO retrieveById(String personaDni) {
        Optional<Persona> persona = personaRepository.findById(personaDni);
        if (persona.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(persona.get());
    }

    public void delete(String personaDni) {
        try {
            personaRepository.deleteById(personaDni);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void replace(String personaId, PersonaDTO personaDTO) {
        Optional<Persona> persona = personaRepository.findById(personaId);
        if (persona.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Persona personaARemplazar = persona.get();
        personaARemplazar.setNombre(personaDTO.getNombre());
        personaARemplazar.setApellido(personaDTO.getApellido());
        personaARemplazar.setEdad(personaDTO.getEdad());
        personaARemplazar.setGenero(personaDTO.getGenero());
        personaARemplazar.setCelular(personaDTO.getCelular());
        personaARemplazar.setEstudia(personaDTO.getEstudia());
        personaARemplazar.setRecibeIngresos(personaDTO.getRecibeIngresos());
        personaRepository.save(personaARemplazar);
    }

    public void modify(String personaDni, Map<String, Object> camposAModificar) {
        Optional<Persona> persona = personaRepository.findById(personaDni);
        if (persona.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Persona personaAModificar = persona.get();
        camposAModificar.forEach((key, value) -> personaAModificar.modifyAttributeValue(key, value));
        personaRepository.save(personaAModificar);
    }

    private void checkForExistingPerson(String personaDni) {
        if (personaRepository.existsById(personaDni)) {
            throw new ExistingResourceException();
        }
    }

    private Persona mapToEntity(PersonaDTO personaDTO) {
        Persona persona = new Persona(personaDTO.getDni(), personaDTO.getNombre(), personaDTO.getApellido(), personaDTO.getGenero(), personaDTO.getCelular(), personaDTO.getEdad(), personaDTO.getEstudia(), personaDTO.getRecibeIngresos());
        return persona;
    }

    private PersonaDTO mapToDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO(persona.getDni(), persona.getNombre(), persona.getApellido(), persona.getGenero(), persona.getCelular(), persona.getEdad(), persona.getEstudia(), persona.getRecibeIngresos());
        return personaDTO;
    }


}