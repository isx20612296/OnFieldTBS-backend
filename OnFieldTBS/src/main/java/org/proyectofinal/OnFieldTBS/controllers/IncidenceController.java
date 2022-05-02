package org.proyectofinal.OnFieldTBS.controllers;


import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.services.IncidenceService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/incidences")
public class IncidenceController {

    private final IncidenceService service;


    public IncidenceController(IncidenceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllIncidence(){
        List<Incidence> allIncidences = service.getAllIncidences();
        return ResponseEntity.ok().body(ListResult.list(allIncidences));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidence> getIncidenceById(@PathVariable UUID id){
        Optional<Incidence> searchIncidence = service.getIncidenceById(id);
        return searchIncidence.map(incidence -> ResponseEntity.ok().body(incidence))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
