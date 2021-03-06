package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.proyectofinal.OnFieldTBS.domains.models.projections.IncidenceByTechnicianId;
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

    @Query("SELECT i FROM Incidence i WHERE i.technician.id = ?1")
    List<IncidenceByTechnicianId>findIncidencesByTechnicianId(UUID technicianId);
}
