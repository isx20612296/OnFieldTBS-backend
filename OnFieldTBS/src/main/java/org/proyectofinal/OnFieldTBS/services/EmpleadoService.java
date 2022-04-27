package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.models.Empleado;
import org.proyectofinal.OnFieldTBS.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }


    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerEmpleadoPorId(UUID id){
        return empleadoRepository.findById(id);
    }

    public boolean borrarEmpleado(UUID id){
        if (obtenerEmpleadoPorId(id).isPresent()){
            empleadoRepository.deleteById(obtenerEmpleadoPorId(id).get().getId_empleado());
            return true;
        }
        return false;
    }
}
