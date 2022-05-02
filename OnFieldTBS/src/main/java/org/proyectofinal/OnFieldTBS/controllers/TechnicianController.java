package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.services.TechnicianService;
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
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService service;

    public TechnicianController(TechnicianService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllTechnicians(){
        List<Technician> allTechnicians = service.getAllTechnicians();
        return ResponseEntity.ok().body(ListResult.list(allTechnicians));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable UUID id){
        Optional<Technician> searchTechnician = service.getTechnicianById(id);
        return searchTechnician.map(technician -> ResponseEntity.ok().body(technician))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
