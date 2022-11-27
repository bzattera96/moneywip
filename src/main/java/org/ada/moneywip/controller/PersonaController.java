package org.ada.moneywip.controller;

import org.ada.moneywip.dto.PersonaDTO;
import org.ada.moneywip.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping(path = "/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody PersonaDTO personaDTO) {
        PersonaDTO createdPersonaDTO = personaService.create(personaDTO);
        return new ResponseEntity(personaDTO.getDni(), HttpStatus.CREATED);
    }

    @GetMapping("/{personaDni}")
    public ResponseEntity retrieveById(@PathVariable String personaDni) {
        PersonaDTO personaDTO = personaService.retrieveById(personaDni);
        return new ResponseEntity(personaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{personaDni}")
    public ResponseEntity delete(@PathVariable String personaDni) {
        personaService.delete(personaDni);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{personaDni}")
    public ResponseEntity replace(@PathVariable String personaDni, @RequestBody PersonaDTO personaDTO) {
        personaService.replace(personaDni, personaDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{personaDni}")
    public ResponseEntity modify (@PathVariable String personaDni, @RequestBody Map<String, Object> camposAModificar) {
        personaService.modify(personaDni, camposAModificar);
        return new ResponseEntity(HttpStatus.OK);
    }
}