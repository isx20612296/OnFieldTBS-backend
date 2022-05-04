package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id","incidence","createdAt","message"})
public interface CommentStandard {
     UUID getId();
     String getMessage();
     LocalDateTime getCreatedAt();

     IncidenceIn getIncidence();
     TechnicianUsername getTechnician();
}
