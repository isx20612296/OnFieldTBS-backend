package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TecnicoRepository extends JpaRepository<Tecnico, UUID> {
}
