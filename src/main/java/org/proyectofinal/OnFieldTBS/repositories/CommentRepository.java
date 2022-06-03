package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentBasic;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {


    List<CommentStandard>findBy();
    Optional<CommentStandard>getCommentById(UUID id);

    @Query("SELECT c FROM Comment c WHERE c.incidence.id = ?1 ")
    List<CommentBasic>findCommentsByIncidenceId(UUID incidenceId);
}
