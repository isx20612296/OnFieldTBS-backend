package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id","createdAt","message"})
public interface CommentBasic {
    UUID getId();
    String getMessage();
    LocalDateTime getCreatedAt();

    TechnicianUsername getTechnician();
}
