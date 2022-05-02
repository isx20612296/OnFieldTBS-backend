package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestComment;
import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.repositories.CommentRepository;
import org.proyectofinal.OnFieldTBS.repositories.TechnicianRepository;
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



    // TODO: Only for test, comments should be listed by their incident ID
    public List<Comment>getAllComments(){
        return repository.findAll();
    }

    public List<Comment>getCommentsByIncidenceId(UUID incidence_id){
        // TODO: test the query
        return repository.findCommentsByIncidenceId(incidence_id.toString());
    }

    public Optional<Comment> getCommentById(UUID id){
        return repository.findById(id);
    }


}
