package org.ada.moneywip.controller;

import org.ada.moneywip.service.MovimientosAhorrosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/movimientos-ahorro" )

public class MovimientosAhorroController {

    private final MovimientosAhorrosService movimientosAhorroService;

    public MovimientosAhorroController(MovimientosAhorrosService movimientosAhorroService) {
        this.movimientosAhorroService = movimientosAhorroService;
    }
}
