package org.proyectofinal.OnFieldTBS.controllers;


import org.proyectofinal.OnFieldTBS.domains.models.projections.TechnicianStandard;
import org.proyectofinal.OnFieldTBS.services.TechnicianService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService service;

    public TechnicianController(TechnicianService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllTechnicians(){
        List<TechnicianStandard> allTechnicians = service.getAllTechnicians();
        return ResponseEntity.ok().body(ListResult.list(allTechnicians));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianStandard> getTechnicianById(@PathVariable UUID id){
        Optional<TechnicianStandard> searchTechnician = service.getTechnicianById(id);
        return searchTechnician.map(technician -> ResponseEntity.ok().body(technician))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/search")
    public ResponseEntity<TechnicianStandard>getTechnicianByUsername(@RequestParam String username){
        TechnicianStandard technician = service.getTechnicianByUsername(username);
        return ResponseEntity.ok(technician);
    }
    @GetMapping("/{id}/incidences")
    public ResponseEntity<ListResult> getIncidencesById(@PathVariable UUID id){
        return ResponseEntity.ok(ListResult.list(service.getIncidencesById(id)));
    }
}
