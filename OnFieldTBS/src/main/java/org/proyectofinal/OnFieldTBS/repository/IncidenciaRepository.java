package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidenciaRepository extends JpaRepository<Incidencia, UUID> {
}
