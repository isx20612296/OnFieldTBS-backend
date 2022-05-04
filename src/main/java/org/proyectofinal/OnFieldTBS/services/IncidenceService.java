package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestIncidence;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceDetail;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.proyectofinal.OnFieldTBS.repositories.IncidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncidenceService {

    private final IncidenceRepository repository;

    @Autowired
    public IncidenceService(IncidenceRepository repository) {
        this.repository = repository;
    }

    public List<IncidenceStandard> getAllIncidences(){
        return repository.findBy();
    }

    public Optional<IncidenceDetail> getIncidenceById(UUID id){
        return repository.getIncidenceById(id);
    }

    public RequestIncidence updateIncidence(UUID id, RequestIncidence requestIncidence){
        if (getIncidenceById(id).isPresent()) {
            Incidence incidence = repository.getById(id);
            incidence.setTitle(requestIncidence.title);
            incidence.setDescription(requestIncidence.description);
            incidence.setState(requestIncidence.state);
            incidence.setPriority(requestIncidence.priority);
            //incidence.setClosedAt(LocalDateTime.now()); // TODO: Verify is the state is Closed
            repository.save(incidence);
            return requestIncidence;
        }
        return null;
    }
}
