package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestTechnician;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceByTechnicianId;
import org.proyectofinal.OnFieldTBS.domains.models.projections.TechnicianStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechnicianService {

    private final TechnicianRepository repository;
    private final IncidenceService incidenceService;

    @Autowired
    public TechnicianService(TechnicianRepository repository, IncidenceService incidenceService) {
        this.repository = repository;
        this.incidenceService = incidenceService;
    }

    public List<TechnicianStandard> getAllTechnicians(){
        return  repository.findBy();
    }

    public Optional<TechnicianStandard> getTechnicianById(UUID id){
        String errorMessage = String.format("The id %s does not exist", id);
        return Optional.ofNullable(repository.getTechnicianById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }

    public Optional<TechnicianStandard> getTechnicianByUsername(String username){
        String errorMessage = String.format("The username %s does not exist", username);
        return Optional.ofNullable(repository.findTechnicianByUsername(username).orElseThrow(() -> new NotFoundException(errorMessage)));
    }

    public List<IncidenceByTechnicianId> getIncidencesById(UUID id){
        getTechnicianById(id);
        return incidenceService.getIncidencesByTechnicianId(id);
    }

    public RequestTechnician updateTechnician(UUID id, RequestTechnician requestTechnician){
         Optional<TechnicianStandard> technicianUpdate = getTechnicianById(id);

         return requestTechnician;
    }

    public boolean deleteTechnician(UUID id){
        if (getTechnicianById(id).isPresent()) {
            repository.deleteById(getTechnicianById(id).get().getId());
            return true;
        }
        return false;
    }

}
