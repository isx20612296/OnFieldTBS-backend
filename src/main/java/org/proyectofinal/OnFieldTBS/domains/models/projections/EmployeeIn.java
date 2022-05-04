package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name"})
public interface EmployeeIn {

     String getName();
     String getLastname();
}
