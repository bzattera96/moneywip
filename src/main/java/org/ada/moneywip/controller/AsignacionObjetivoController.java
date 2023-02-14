package org.ada.moneywip.controller;

import org.ada.moneywip.dto.AsignacionObjetivoDTO;
import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.entity.AsignacionObjetivo;
import org.ada.moneywip.service.AsignacionObjetivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController

    @RequestMapping(path = "/asignacion-objetivos")
    public class AsignacionObjetivoController {

        private final AsignacionObjetivoService asignacionObjetivoService;

        public AsignacionObjetivoController(AsignacionObjetivoService asignacionObjetivoService) {
            this.asignacionObjetivoService = asignacionObjetivoService;
        }

    @PostMapping
    public ResponseEntity create (@RequestBody AsignacionObjetivoDTO asignacionObjetivoDTO){
        AsignacionObjetivoDTO createdAsignacionObjetivoDTO = asignacionObjetivoService.create(asignacionObjetivoDTO);
        return new ResponseEntity(asignacionObjetivoDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping ("/{Id}") //get general, va con list y solo dni, != si uso el id de la persona + id del ingreso, uno solo
    public ResponseEntity retrieveById (@PathVariable Integer Id){
        AsignacionObjetivoDTO asignacionObjetivoDTO = asignacionObjetivoService.retrieveById(Id);
        return new ResponseEntity(asignacionObjetivoDTO, HttpStatus.OK);
    }


    @PatchMapping ("/{Id}")
    public ResponseEntity modify (@PathVariable Integer Id, @RequestBody Map<String , Object> camposAModificar){
        asignacionObjetivoService.modify(Id, camposAModificar);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity delete (@PathVariable Integer Id){
        asignacionObjetivoService.delete(Id);
        return new ResponseEntity(HttpStatus.OK);
    }

    }

