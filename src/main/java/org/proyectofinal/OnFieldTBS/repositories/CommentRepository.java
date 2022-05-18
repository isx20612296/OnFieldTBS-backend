package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CommentStandard;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {


    List<CommentStandard>findBy();
    Optional<CommentStandard>getCommentById(UUID id);

}
