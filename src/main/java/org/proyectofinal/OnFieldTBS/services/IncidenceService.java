package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestComment;
import org.proyectofinal.OnFieldTBS.domains.dtos.RequestIncidence;
import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.domains.models.projections.*;
import org.proyectofinal.OnFieldTBS.exceptions.ErrorSaveDataException;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
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

    private final CommentService commentService;


    private final TechnicianService technicianService;

    @Autowired
    public IncidenceService(IncidenceRepository repository, CommentService commentService, TechnicianService technicianService) {
        this.repository = repository;
        this.commentService = commentService;
        this.technicianService = technicianService;
    }

    public List<IncidenceStandard> getAllIncidences(){
        return repository.findBy();
    }

    public Optional<IncidenceDetail> getIncidenceById(UUID id){
        return Optional.ofNullable(repository.getIncidenceById(id).orElseThrow(() -> new NotFoundException(errorNotFound(id))));
    }


    public List<IncidenceByTechnicianId>getIncidencesByTechnicianId(UUID technicianId){
        return repository.findIncidencesByTechnicianId(technicianId);
    }


    // COMMENTS
    public List<CommentBasic>getCommentsById(UUID id){
        getIncidenceById(id);
        return commentService.getCommentsByIncidenceId(id);
    }

    public Optional<CommentStandard> saveComment(UUID incidenceId, RequestComment comment){
        Incidence incidence = repository.findById(incidenceId).orElseThrow(() -> new NotFoundException(errorNotFound(incidenceId)));
        Technician technician = technicianService.findTechnicianByUsername(comment.technicianUsername).get();
        Comment newComment = new Comment();
        newComment.setIncidence(incidence);
        newComment.setTechnician(technician);
        newComment.setCreatedAt(LocalDateTime.now());
        newComment.setMessage(comment.message);

        Optional<CommentStandard> saveComment = commentService.save(newComment);
        return Optional.ofNullable(saveComment
                .orElseThrow(() -> new ErrorSaveDataException("Something went wrong trying to save to the database")));
    }


    public IncidenceDetail updateIncidence(UUID id, RequestIncidence requestIncidence){
        Incidence incidence = repository.findById(id).orElseThrow(() -> new NotFoundException(errorNotFound(id)));
        if (requestIncidence.state.equals("Cerrado") && !incidence.getState().equals("Cerrado")){
            incidence.setClosedAt(LocalDateTime.now());
            Comment closedComment = new Comment();
            closedComment.setIncidence(incidence);
            closedComment.setTechnician(incidence.getTechnician());
            closedComment.setCreatedAt(LocalDateTime.now());
            closedComment.setMessage("Incidence closed by " + incidence.getTechnician().getUser().getUsername());
            commentService.save(closedComment);
        }
        if (!incidence.getState().equals("Cerrado")) {
            incidence.setPriority(requestIncidence.priority);
        }
        incidence.setState(requestIncidence.state);

        repository.save(incidence);
        return getIncidenceById(incidence.getId()).get();
    }

    private String errorNotFound(UUID id) {
        return String.format("The incidence with id %s does not exist", id);
    }

}
