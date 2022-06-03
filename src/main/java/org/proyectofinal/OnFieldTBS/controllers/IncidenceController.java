package org.proyectofinal.OnFieldTBS.controllers;


import org.proyectofinal.OnFieldTBS.domains.dtos.RequestComment;
import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentBasic;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceDetail;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.proyectofinal.OnFieldTBS.repositories.CommentRepository;
import org.proyectofinal.OnFieldTBS.services.IncidenceService;
import org.proyectofinal.OnFieldTBS.services.TechnicianService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.proyectofinal.OnFieldTBS.utils.ListResult.list;

@RestController
@RequestMapping("/incidences")
public class IncidenceController {

    private final IncidenceService service;
    private final TechnicianService technicianService;




    public IncidenceController(IncidenceService service, TechnicianService technicianService) {
        this.service = service;
        this.technicianService = technicianService;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllIncidence(){
        List<IncidenceStandard> allIncidences = service.getAllIncidences();
        return ResponseEntity.ok().body(list(allIncidences));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenceDetail> getIncidenceById(@PathVariable UUID id){
        Optional<IncidenceDetail> searchIncidence = service.getIncidenceById(id);
        return searchIncidence.map(incidence -> ResponseEntity.ok().body(incidence))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }



     // COMMENTS

    @GetMapping("/{id}/comments")
    public ResponseEntity<ListResult>getCommentsById(@PathVariable UUID id){
        return ResponseEntity.ok().body(list(service.getCommentsById(id)));
    }

    @GetMapping("/{id}/comment")
    public ResponseEntity<CommentBasic>addCommentToIncidence(@PathVariable UUID id, @RequestBody RequestComment comment){
        Incidence incidence = service.findIncidenceById(id).get();
        Technician technician = technicianService.findTechnicianByUsername(comment.technicianUsername).get();
        Comment newComment = new Comment();
        newComment.setIncidence(incidence);
        newComment.setTechnician(technician);
        newComment.setCreatedAt(LocalDateTime.now());
        newComment.setMessage(comment.message);


        return null;
    }

}
