package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentBasic;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }



    public Optional<CommentStandard> getCommentById(UUID id){
        String errorMessage = String.format("The comment with id %s does not exist", id);
        return Optional.ofNullable(repository.getCommentById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }

    public List<CommentBasic>getCommentsByIncidenceId(UUID incidenceId){
        return repository.findCommentsByIncidenceId(incidenceId);
    }

    public Optional<CommentStandard> save(Comment comment) {
        Comment newComment = repository.save(comment);
        return repository.getCommentById(newComment.getId());
    }
}
