package org.ada.moneywip.controller;

import org.ada.moneywip.service.TipoIngresoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/tipo-ingreso")
public class TipoIngresoController {
    private final TipoIngresoService tipoIngresoService;

    public TipoIngresoController(TipoIngresoService tipoIngresoService) {
        this.tipoIngresoService = tipoIngresoService;
    }
}
