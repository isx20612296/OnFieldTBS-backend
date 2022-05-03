package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id", "name","description", "price"})

public interface MaintenanceStandard {
     UUID getId();
     String getName();
     String getDescription();
     Double getPrice();
}
