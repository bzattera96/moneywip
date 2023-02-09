package org.ada.moneywip.controller;

import org.ada.moneywip.dto.ObjetivoDTO;
import org.ada.moneywip.service.ObjetivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping(path = "/objetivos")

public class ObjetivoController {
    private final ObjetivoService objetivoService;

    public ObjetivoController(ObjetivoService objetivoService) {
        this.objetivoService = objetivoService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody ObjetivoDTO objetivoDTO) {
        ObjetivoDTO createdObjetivoDTO = objetivoService.create(objetivoDTO);
        return new ResponseEntity(objetivoDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity retrieveById(@PathVariable Integer id) {
        ObjetivoDTO objetivoDTO = objetivoService.retrieveByObjetivoId(id);
        return new ResponseEntity(objetivoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        objetivoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity modify (@PathVariable Integer id, @RequestBody Map<String, Object> camposAModificar) {
        objetivoService.modify(id, camposAModificar);
        return new ResponseEntity(HttpStatus.OK);
    }
}