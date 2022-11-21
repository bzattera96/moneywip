package org.ada.moneywip.controller;

import org.ada.moneywip.entity.AsignacionObjetivo;
import org.ada.moneywip.service.AsignacionObjetivoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController

    @RequestMapping(path = "/asignacion-objetivo")
    public class AsignacionObjetivoController {

        private final AsignacionObjetivoService asignacionObjetivoService;


        public AsignacionObjetivoController(AsignacionObjetivoService asignacionObjetivoService) {
            this.asignacionObjetivoService = asignacionObjetivoService;
        }
    }

