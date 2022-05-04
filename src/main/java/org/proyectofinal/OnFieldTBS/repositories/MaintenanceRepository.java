package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Maintenance;
import org.proyectofinal.OnFieldTBS.domains.models.projections.MaintenanceStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {

    List<MaintenanceStandard> findBy();

    Optional<MaintenanceStandard> getMaintenanceById(UUID id);
}
