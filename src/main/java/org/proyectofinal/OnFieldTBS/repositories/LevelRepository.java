package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Level;
import org.proyectofinal.OnFieldTBS.domains.models.projections.LevelStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LevelRepository extends JpaRepository<Level, UUID> {

    List<LevelStandard> findBy();
    Optional<LevelStandard>getLevelById(UUID id);
}
