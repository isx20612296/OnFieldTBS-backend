package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.Maintenance;
import org.proyectofinal.OnFieldTBS.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MaintenanceService {

    private final MaintenanceRepository repository;

    @Autowired
    public MaintenanceService(MaintenanceRepository repository) {
        this.repository = repository;
    }

    public List<Maintenance> getAllMaintenance(){
        return repository.findAll();
    }

    public Optional<Maintenance> getMaintenanceById(UUID id){
        return repository.findById(id);
    }
}
