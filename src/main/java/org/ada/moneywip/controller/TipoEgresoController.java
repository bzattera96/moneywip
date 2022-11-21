package org.ada.moneywip.controller;

import org.ada.moneywip.entity.TipoEgreso;
import org.ada.moneywip.service.TipoEgresoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/tipo-egreso")

public class TipoEgresoController {

    private final TipoEgresoService tipoEgresoService;

    public TipoEgresoController(TipoEgresoService tipoEgresoService) {
        this.tipoEgresoService = tipoEgresoService;
    }
}
