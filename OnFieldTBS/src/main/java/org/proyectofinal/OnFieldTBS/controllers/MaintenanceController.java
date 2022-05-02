package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.proyectofinal.OnFieldTBS.domains.models.Maintenance;
import org.proyectofinal.OnFieldTBS.services.MaintenanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllMaintenance(){
        List<Maintenance> allMaintenance = service.getAllMaintenance();
        return ResponseEntity.ok().body(ListResult.list(allMaintenance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance>getMaintenanceById(@PathVariable UUID id){
        Optional<Maintenance>searchMaintenance = service.getMaintenanceById(id);
        return searchMaintenance.map(maintenance -> ResponseEntity.ok().body(maintenance))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
