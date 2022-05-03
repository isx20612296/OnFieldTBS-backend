package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name"})
public interface TechnicianIn {

    String getName();
    String getLastname();


}
