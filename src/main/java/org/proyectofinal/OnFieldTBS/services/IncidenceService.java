package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestIncidence;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentBasic;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceByTechnicianId;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceDetail;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.repositories.IncidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncidenceService {

    private final IncidenceRepository repository;

    private final CommentService commentService;

    @Autowired
    public IncidenceService(IncidenceRepository repository, CommentService commentService) {
        this.repository = repository;
        this.commentService = commentService;
    }

    public List<IncidenceStandard> getAllIncidences(){
        return repository.findBy();
    }

    public Optional<IncidenceDetail> getIncidenceById(UUID id){
        String errorMessage = String.format("The incidence with id %s does not exist", id);
        return Optional.ofNullable(repository.getIncidenceById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }

    public Optional<Incidence> findIncidenceById(UUID id){
        String errorMessage = String.format("The incidence with id %s does not exist", id);
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
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

    public List<IncidenceByTechnicianId>getIncidencesByTechnicianId(UUID technicianId){
        return repository.findIncidencesByTechnicianId(technicianId);
    }


    public List<CommentBasic>getCommentsById(UUID id){
        getIncidenceById(id);
        return commentService.getCommentsByIncidenceId(id);
    }



}
