package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "description"})
public interface MaintenanceIn {

    String getName();
    String getDescription();

}
