package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {
}
