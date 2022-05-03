package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "description"})
public interface LevelStandard {

    UUID getId();
    String getName();
    String getDescription();

    Set<TechnicianIn> getTechnicians();


}
