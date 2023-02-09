package org.ada.moneywip.controller;

import org.ada.moneywip.dto.TipoEgresoDTO;
import org.ada.moneywip.dto.TipoIngresoDTO;
import org.ada.moneywip.entity.TipoEgreso;
import org.ada.moneywip.service.TipoEgresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping(path = "/tipos-egreso")
public class TipoEgresoController {
    private final TipoEgresoService tipoEgresoService;

    public TipoEgresoController(TipoEgresoService tipoEgresoService) {

        this.tipoEgresoService = tipoEgresoService;
    }
    @PostMapping
    public ResponseEntity create (@RequestBody TipoEgresoDTO tipoEgresoDTO) {
        TipoEgresoDTO createdTipoEgresoDTO = tipoEgresoService.create(tipoEgresoDTO);
        return new ResponseEntity(createdTipoEgresoDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping ("/{tipoEgresoId}")
    public ResponseEntity retrieveById(@PathVariable Integer tipoEgresoId){
        TipoEgresoDTO tipoEgresoDTO = tipoEgresoService.retrieveByTipoEgresoId(tipoEgresoId);
        return new ResponseEntity(tipoEgresoDTO, HttpStatus.OK);
    }

    @DeleteMapping ("/{tipoEgresoId}")
    public ResponseEntity delete (@PathVariable Integer tipoEgresoId){
        tipoEgresoService.delete(tipoEgresoId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PatchMapping ("/{tipoEgresoId}")
    public ResponseEntity modify (@PathVariable Integer tipoEgresoId, @RequestBody Map<String,Object> fieldsToModify){
        tipoEgresoService.modify(tipoEgresoId, fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }
}
