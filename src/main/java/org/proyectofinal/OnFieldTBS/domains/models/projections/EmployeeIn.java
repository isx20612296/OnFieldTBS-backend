package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id","name"})
public interface EmployeeIn {

     UUID getId();
     String getName();
     String getLastname();
}
