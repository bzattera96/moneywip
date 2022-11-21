package org.ada.moneywip.controller;

import org.ada.moneywip.service.IngresoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController

    @RequestMapping(path = "/ingreso")
    public class IngresoController {
        private final IngresoService ingresoService;

        public IngresoController(IngresoService ingresoService) {
            this.ingresoService = ingresoService;
        }

    }

