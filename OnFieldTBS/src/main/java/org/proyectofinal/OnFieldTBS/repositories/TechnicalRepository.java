package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnicalRepository extends JpaRepository<Technical, UUID> {
}
