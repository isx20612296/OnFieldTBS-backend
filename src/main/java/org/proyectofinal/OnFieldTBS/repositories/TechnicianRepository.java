package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.domains.models.projections.TechnicianStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TechnicianRepository extends JpaRepository<Technician, UUID> {

    List<TechnicianStandard> findBy();
    Optional<TechnicianStandard>getTechnicianById(UUID id);

    @Query("SELECT t FROM Technician t WHERE t.user.username = ?1")
    TechnicianStandard findTechnicianByUsername(String username);


}
