package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnicalRepository extends JpaRepository<Technical, UUID> {
}
