package org.ada.moneywip.controller;

import org.ada.moneywip.dto.EgresoDTO;
import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.service.EgresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.PortUnreachableException;
import java.util.List;
import java.util.Map;

@RestController

    @RequestMapping (path = "/personas/{personaDni}/egresos")
     public class EgresoController {

          private final EgresoService egresoService;

    public EgresoController(EgresoService egresoService){
    this.egresoService = egresoService;
    }

   @PostMapping
    public ResponseEntity create (@RequestBody EgresoDTO egresoDTO , @PathVariable String personaDni){
        EgresoDTO createdEgresoDTO= egresoService.create(egresoDTO);
        return new ResponseEntity(egresoDTO.getId(), HttpStatus.CREATED);
    }
    @GetMapping ("/{egresoId}")
    public ResponseEntity retrieveById (@PathVariable Integer egresoId){
        EgresoDTO egresoDTO = egresoService.retrieveById(egresoId);
        return new ResponseEntity(egresoDTO, HttpStatus.OK);
    }

    @PatchMapping ("/{egresoId}")
    public ResponseEntity modify (@PathVariable Integer egresoId, @RequestBody Map<String , Object> camposAModificar){
        egresoService.modify(egresoId, camposAModificar);
        return  new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping ("/{egresoId}")
    public ResponseEntity delete (@PathVariable Integer egresoId){
        egresoService.delete(egresoId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping ("/{egresoId}/{fechaInicio}/{fechaFinal}")
    public ResponseEntity resumenEgresos (@PathVariable String personaDni, String fechaInicio, String fechaFinal) {
        List<EgresoDTO> resumenEgresos = egresoService.resumenEgresos(personaDni, fechaInicio, fechaFinal);
        return new ResponseEntity(resumenEgresos, HttpStatus.OK);
    }
}