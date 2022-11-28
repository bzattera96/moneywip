package org.ada.moneywip.controller;

import org.ada.moneywip.dto.TipoIngresoDTO;
import org.ada.moneywip.service.TipoIngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping(path = "/tipos-ingreso") //tipos-ingreso
public class TipoIngresoController {
    private final TipoIngresoService tipoIngresoService;

    public TipoIngresoController(TipoIngresoService tipoIngresoService) {
        this.tipoIngresoService = tipoIngresoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TipoIngresoDTO tipoIngresoDTO ) {
        TipoIngresoDTO createdTipoIngresoDTO = tipoIngresoService.create(tipoIngresoDTO);
        return new ResponseEntity(createdTipoIngresoDTO.getId(), HttpStatus.CREATED); //debería darme el id autogenerado en la base de datos?
    }

    @GetMapping ("/{tipoIngresoId}")
    public ResponseEntity retrieveById(@PathVariable Integer tipoIngresoId){
        TipoIngresoDTO tipoIngresoDTO = tipoIngresoService.retrieveByTipoIngresoId(tipoIngresoId);
            return new ResponseEntity(tipoIngresoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{tipoIngresoId}") //eliminar por Id, todo lo que no es post que se crea con autogenerado
    public ResponseEntity delete(@PathVariable Integer tipoIngresoId) {
        tipoIngresoService.delete(tipoIngresoId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{tipoIngresoId}")
    public ResponseEntity modify (@PathVariable Integer tipoIngresoId, @RequestBody Map<String, Object> fieldsToModify){ //object porque puede ser String, numero, integer, etc
        tipoIngresoService.modify(tipoIngresoId, fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }
}
