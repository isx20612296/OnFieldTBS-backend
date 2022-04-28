package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.models.Employee;
import org.proyectofinal.OnFieldTBS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeId(UUID id){
        return employeeRepository.findById(id);
    }

    public boolean borrarEmpleado(UUID id){
        if (getEmployeeId(id).isPresent()){
            employeeRepository.deleteById(getEmployeeId(id).get().getId());
            return true;
        }
        return false;
    }
}
