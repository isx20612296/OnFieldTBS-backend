package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.domains.models.Level;
import org.proyectofinal.OnFieldTBS.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/levels")
public class LevelController {


    private final LevelService service;

    @Autowired
    public LevelController(LevelService service) {
        this.service = service;
    }


    @GetMapping
    public List<Level> listAllLevels(){
        return service.getAllLevels();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable UUID id){
        Optional<Level> searchLevel = service.getLevelById(id);
        return searchLevel.map(level -> ResponseEntity.ok().body(level))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
