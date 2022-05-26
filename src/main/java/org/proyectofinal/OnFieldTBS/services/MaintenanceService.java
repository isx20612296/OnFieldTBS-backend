package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.projections.MaintenanceStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
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
        String errorMessage = String.format("The maintenance with id %s does not exist", id);
        return Optional.ofNullable(repository.getMaintenanceById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }
}
