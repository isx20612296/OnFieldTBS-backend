package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.Employee;
import org.proyectofinal.OnFieldTBS.domains.models.projections.EmployeeStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findByEmail(String email);
    List<EmployeeStandard> findBy();
    Optional<EmployeeStandard> getEmployeeById(UUID id);

}
