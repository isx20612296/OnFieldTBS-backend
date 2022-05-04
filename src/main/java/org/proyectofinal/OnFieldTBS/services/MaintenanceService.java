package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.projections.MaintenanceStandard;
import org.proyectofinal.OnFieldTBS.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MaintenanceService {

    private final MaintenanceRepository repository;

    @Autowired
    public MaintenanceService(MaintenanceRepository repository) {
        this.repository = repository;
    }

    public List<MaintenanceStandard> getAllMaintenance(){
        return repository.findBy();
    }

    public Optional<MaintenanceStandard> getMaintenanceById(UUID id){
        return repository.getMaintenanceById(id);
    }
}
