package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Comment;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceDetail;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {

    List<IncidenceStandard> findBy();
    Optional<IncidenceDetail>getIncidenceById(UUID id);


    @Query("SELECT c FROM Comment c WHERE c.incidence.getId() = ?1 ")
    List<Comment>findCommentsByIncidenceId(String incidence_id);
}
