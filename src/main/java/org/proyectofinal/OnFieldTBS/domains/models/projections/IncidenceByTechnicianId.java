package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority;
import org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "status", "priority", "createdAt"})
public interface IncidenceByTechnicianId {

     UUID getId();
     String getTitle();
     String getDescription();
     IncidenceStatus getStatus();
     IncidencePriority getPriority();
     LocalDateTime getCreatedAt();
     LocalDateTime getClosedAt();


}
