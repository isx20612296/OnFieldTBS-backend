package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"technician","createdAt","message"})
public interface CommentBasic {
    String getMessage();
    LocalDateTime getCreatedAt();

    TechnicianUsername getTechnician();
}
