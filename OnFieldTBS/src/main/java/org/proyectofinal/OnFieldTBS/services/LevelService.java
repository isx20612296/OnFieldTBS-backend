package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.projections.LevelStandard;
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
        return repository.getLevelById(id);
    }
}
