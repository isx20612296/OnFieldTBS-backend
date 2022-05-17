package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"id","name", "lastname", "phone","createAt", "user", "level"})
public interface TechnicianStandard {

     UUID getId();
     String getName();
     String getLastname();
     String getPhone();
     String getEmail();
     LocalDate getCreatedAt();
     UserBasic getUser();
     LevelIn getLevel();
     Set<IncidenceIn> getIncidences();
}
