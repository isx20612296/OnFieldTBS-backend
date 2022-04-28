package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestEmployee;
import org.proyectofinal.OnFieldTBS.domains.models.Employee;
import org.proyectofinal.OnFieldTBS.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(UUID id){
        return repository.findById(id);
    }


    public RequestEmployee updateEmployee(String email, RequestEmployee requesEmployee){
        Employee employeeUpdate = repository.findByEmail(email);
        employeeUpdate.setName(requesEmployee.name); // TODO : preguntar Gerald
        employeeUpdate.setLastname(requesEmployee.lastname);
        employeeUpdate.setPhoneExt(requesEmployee.phoneExt);
        employeeUpdate.setDirectPhone(requesEmployee.directPhone);
        repository.save(employeeUpdate);
        return requesEmployee;
    }

    public boolean deleteEmployee(UUID id){
        if (getEmployeeById(id).isPresent()){
            repository.deleteById(getEmployeeById(id).get().getId());
            return true;
        }
        return false;
    }
}
