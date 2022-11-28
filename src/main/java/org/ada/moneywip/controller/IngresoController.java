package org.ada.moneywip.controller;

import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController

    @RequestMapping(path = "/personas/{personaDni}/ingresos")
    public class IngresoController {
        private final IngresoService ingresoService;

        public IngresoController(IngresoService ingresoService) {
            this.ingresoService = ingresoService;
        }

        @PostMapping
        public ResponseEntity create (@RequestBody IngresoDTO ingresoDTO, @PathVariable String personaDni){
            IngresoDTO createdIngresoDTO = ingresoService.create(ingresoDTO);
            return new ResponseEntity(ingresoDTO.getId(), HttpStatus.CREATED);
        }

        @GetMapping ("/{ingresoId}") //get general, va con list y solo dni, != si uso el id de la persona + id del ingreso, uno solo
        public ResponseEntity retrieveById (@PathVariable Integer ingresoId){
                IngresoDTO ingresoDTO = ingresoService.retrieveById(ingresoId);
                return new ResponseEntity(ingresoDTO, HttpStatus.OK);
        }


        @PatchMapping ("/{ingresoId}")
        public ResponseEntity modify (@PathVariable Integer ingresoId, @RequestBody Map<String , Object> camposAModificar){
            ingresoService.modify(ingresoId, camposAModificar);
            return new ResponseEntity(HttpStatus.OK);
        }

        @DeleteMapping("/{ingresoId}")
        public ResponseEntity delete (@PathVariable Integer ingresoId){
            ingresoService.delete(ingresoId);
            return new ResponseEntity(HttpStatus.OK);
        }


    }

