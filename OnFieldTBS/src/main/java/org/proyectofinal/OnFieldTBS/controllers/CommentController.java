package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentStandard;
import org.proyectofinal.OnFieldTBS.services.CommentService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<ListResult> listAllComments(){
        List<CommentStandard> allComments = service.getAllComments();
        return ResponseEntity.ok().body(ListResult.list(allComments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentStandard> getCommentById(@PathVariable UUID id){
        Optional<CommentStandard> searchComment = service.getCommentById(id);
        return searchComment.map(comment -> ResponseEntity.ok().body(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
