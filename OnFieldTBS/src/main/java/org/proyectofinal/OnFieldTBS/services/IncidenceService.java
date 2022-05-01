package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestIncidence;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.repositories.IncidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
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

    public List<Incidence> getAllIncidences(){
        return repository.findAll();
    }

    public Optional<Incidence>getIncidenceById(UUID id){
        return repository.findById(id);
    }

    public RequestIncidence updateIncidence(UUID id, RequestIncidence requestIncidence){
        if (getIncidenceById(id).isPresent()) {
            Incidence incidence = getIncidenceById(id).get();
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
