package org.proyectofinal.OnFieldTBS.repository;

import org.proyectofinal.OnFieldTBS.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpleadoRepository extends JpaRepository<Empleado, UUID> {

}
