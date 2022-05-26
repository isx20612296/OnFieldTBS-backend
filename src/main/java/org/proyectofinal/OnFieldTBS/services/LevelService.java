package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.projections.LevelStandard;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.repositories.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LevelService {

    private final LevelRepository repository;

    @Autowired
    public LevelService(LevelRepository repository) {
        this.repository = repository;
    }

    public List<LevelStandard> getAllLevels(){
        return repository.findBy();
    }

    public Optional<LevelStandard> getLevelById(UUID id){
        String errorMessage = String.format("The level with id %s does not exist", id);
        return Optional.ofNullable(repository.getLevelById(id).orElseThrow(() -> new NotFoundException(errorMessage)));
    }
}
