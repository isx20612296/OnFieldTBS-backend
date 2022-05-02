package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.domains.models.Employee;
import org.proyectofinal.OnFieldTBS.services.EmployeeService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult>  listAllEmployees(){
        List<Employee> allEmployees = service.getAllEmployees();
        return ResponseEntity.ok().body(ListResult.list(allEmployees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id){
        Optional<Employee> searchEmployee = service.getEmployeeById(id);
        return searchEmployee.map(employee -> ResponseEntity.ok().body(employee))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
