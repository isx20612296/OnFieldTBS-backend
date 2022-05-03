package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {

    List<IncidenceStandard> findBy();
    Optional<IncidenceStandard>getIncidenceById(UUID id);
}
