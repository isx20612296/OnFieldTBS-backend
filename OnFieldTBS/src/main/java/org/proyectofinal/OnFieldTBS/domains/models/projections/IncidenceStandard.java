package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "state", "priority", "createdAt", "closedAt"})
public interface IncidenceStandard {

     UUID getId();
     String getTitle();
     String getDescription();
     String getState();
     String getPriority();
     LocalDateTime getCreatedAt();
     LocalDateTime getClosedAt();
     CompanyIn getCompany();

}
