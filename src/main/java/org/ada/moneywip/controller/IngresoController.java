package org.ada.moneywip.controller;

import org.ada.moneywip.dto.IngresoDTO;
import org.ada.moneywip.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController

    @RequestMapping(path = "/ingreso")
    public class IngresoController {
        private final IngresoService ingresoService;

        public IngresoController(IngresoService ingresoService) {
            this.ingresoService = ingresoService;
        }



        @PostMapping
        public ResponseEntity create (@RequestBody IngresoDTO ingresoDTO, String personaId, Integer tipoIngresoId){
            IngresoDTO createdIngresoDTO = ingresoService.create(ingresoDTO, personaId, tipoIngresoId);
            return new ResponseEntity(ingresoDTO.getId(), HttpStatus.CREATED);
        }

        @GetMapping ("/{personaDni}")
        public ResponseEntity retrieveById (@PathVariable String personaDni){
                IngresoDTO ingresoDTO = ingresoService.retrieveById(personaDni);
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

