package org.ada.moneywip.controller;

import org.ada.moneywip.dto.MovimientosAhorroDTO;
import org.ada.moneywip.service.MovimientosAhorrosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping (path = "/movimientos-ahorro")

public class MovimientosAhorroController {

    private final MovimientosAhorrosService movimientosAhorroService;

    public MovimientosAhorroController(MovimientosAhorrosService movimientosAhorroService) {
        this.movimientosAhorroService = movimientosAhorroService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody MovimientosAhorroDTO movimientosAhorroDTO) {
        MovimientosAhorroDTO createdMovimientosAhorroDTO = movimientosAhorroService.create(movimientosAhorroDTO);
        return new ResponseEntity(movimientosAhorroDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity retrieveById(@PathVariable Integer id) {
        MovimientosAhorroDTO movimientosAhorroDTO = movimientosAhorroService.retrieveById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        movimientosAhorroService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity modify (@PathVariable Integer id, @RequestBody Map<String, Object> camposAModificar) {
        movimientosAhorroService.modify(id, camposAModificar);
        return new ResponseEntity(HttpStatus.OK);
    }
}