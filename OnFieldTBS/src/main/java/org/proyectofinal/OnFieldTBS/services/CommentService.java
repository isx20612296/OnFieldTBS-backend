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
    private final TechnicianRepository technicianRepository;

    @Autowired
    public CommentService(CommentRepository repository, TechnicianRepository technicianRepository) {
        this.repository = repository;
        this.technicianRepository = technicianRepository;
    }

    // TODO: Only for test, comments should be listed by their incident ID
    public List<Comment>getComments(){
        return repository.findAll();
    }

    public List<Comment>getCommentsByIncidenceId(UUID incidence_id){
        // TODO: test the query
        return repository.findCommentsByIncidenceId(incidence_id.toString());
    }

    public Optional<Comment> getCommentById(UUID id){
        return repository.findById(id);
    }

    // TODO: update logic needs to be improved
    public boolean updateComment(UUID id, RequestComment requestComment){
        if (getCommentById(id).isPresent()){
            Comment comment = getCommentById(id).get();
            comment.setMessage(requestComment.message);
            if (technicianRepository.findByUsername(requestComment.technicianUsername) != null){
                comment.getTechnician().setUsername(requestComment.technicianUsername);
            }else {
                return false;
            }
            repository.save(comment);
        }
        return true;
    }
}
