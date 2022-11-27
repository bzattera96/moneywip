package org.ada.moneywip.controller;

import org.ada.moneywip.dto.TipoIngresoDTO;
import org.ada.moneywip.service.TipoIngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping(path = "/tipo-ingreso")
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

    @GetMapping ("/{tipoIngreso}")
    public ResponseEntity retrieveById(@PathVariable String tipoIngreso){
        TipoIngresoDTO tipoIngresoDTO = tipoIngresoService.retrieveByTipoIngreso(tipoIngreso);
            return new ResponseEntity(tipoIngresoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{tipoIngreso}")
    public ResponseEntity delete(@PathVariable String tipoIngreso) {
        tipoIngresoService.delete(tipoIngreso);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{tipoIngreso}")
    public ResponseEntity modify (@PathVariable Integer tipoIngresoId, @RequestBody Map<String, Object> fieldsToModify){ //object porque puede ser String, numero, integer, etc
        tipoIngresoService.modify(tipoIngresoId, fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }
}
