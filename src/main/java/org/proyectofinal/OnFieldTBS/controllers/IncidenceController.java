package org.proyectofinal.OnFieldTBS.controllers;


import org.proyectofinal.OnFieldTBS.domains.dtos.RequestComment;
import org.proyectofinal.OnFieldTBS.domains.dtos.RequestIncidence;
import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentStandard;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceDetail;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.proyectofinal.OnFieldTBS.exceptions.BadRequestException;
import org.proyectofinal.OnFieldTBS.services.IncidenceService;
import org.proyectofinal.OnFieldTBS.services.TechnicianService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.HttpStatus;
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


    public IncidenceController(IncidenceService service) {
        this.service = service;
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


    @PutMapping("/{id}")
    public ResponseEntity<IncidenceDetail> updateIncidence(@PathVariable UUID id, @RequestBody RequestIncidence requestIncidence){
        service.existIncidence(id);
        // TODO: buscar una forma de validar el request body antes de que lo haga spring, exception HttpMessageNotReadableException
//        boolean invalidState = requestIncidence.status.getValue().equals("") ||requestIncidence.status.getValue().equals(" ");
//        boolean invalidPriority = requestIncidence.priority.getValue().equals("") || requestIncidence.priority.getValue().equals(" ");
//
//        if (invalidState || invalidPriority){
//            throw new BadRequestException("the state or priority not could be blank");
//        }

        return ResponseEntity.ok().body(service.updateIncidence(id, requestIncidence));
    }


     // COMMENTS

    @GetMapping("/{id}/comments")
    public ResponseEntity<ListResult>getCommentsById(@PathVariable UUID id){
        return ResponseEntity.ok().body(list(service.getCommentsById(id)));
    }



    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentStandard> addCommentToIncidence(@PathVariable UUID id, @RequestBody RequestComment comment){
        boolean invalidMessage = comment.message.equals("")|| comment.message.equals(" ");
        boolean invalidUsername =  comment.technicianUsername.equals("")|| comment.technicianUsername.equals(" ");
        if (invalidMessage || invalidUsername){
            throw new BadRequestException("the username or message not could be blank");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveComment(id, comment).get());
    }

}
