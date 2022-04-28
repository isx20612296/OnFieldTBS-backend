package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {
}
