package org.proyectofinal.OnFieldTBS.services;


import org.proyectofinal.OnFieldTBS.domains.models.Level;
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

    public List<Level> getAllLevels(){
        return repository.findAll();
    }

    public Optional<Level> getLevelById(UUID id){
        return repository.findById(id);
    }
}
