package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidenceRepository extends JpaRepository<Incidence, UUID> {
}
