package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {


    @Query("SELECT c FROM Comment c WHERE c.incidence.getId() = ?1 ")
    List<Comment>findCommentsByIncidenceId(String incidence_id);
}
