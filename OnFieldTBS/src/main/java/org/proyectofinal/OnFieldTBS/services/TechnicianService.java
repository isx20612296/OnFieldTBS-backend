package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestTechnician;
import org.proyectofinal.OnFieldTBS.domains.models.Technician;
import org.proyectofinal.OnFieldTBS.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechnicianService {

    private  final TechnicianRepository repository;

    @Autowired
    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    public List<Technician> getAllTechnicians(){
        return  repository.findAll();
    }

    public Optional<Technician> getTechnicianById(UUID id){
        return repository.findById(id);
    }

    public RequestTechnician updateTechnician(String username, RequestTechnician requestTechnician){
         Technician technicianUpdate = repository.findByUsername(username);


         return requestTechnician;
    }


    public boolean deleteTechnician(UUID id){
        if (getTechnicianById(id).isPresent()) {
            repository.deleteById(getTechnicianById(id).get().getId());
            return true;
        }
        return false;
    }
}
