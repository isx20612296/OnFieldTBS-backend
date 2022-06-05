package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority;
import org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "status", "priority", "createdAt", "closedAt", "description","employee", "company","technician"})
public interface IncidenceDetail {
     UUID getId();
     String getTitle();
     String getDescription();
     IncidenceStatus getStatus();
     IncidencePriority getPriority();
     LocalDateTime getCreatedAt();
     LocalDateTime getClosedAt();


     CompanyIn getCompany();
     EmployeeIn getEmployee();
     TechnicianIn getTechnician();
     Set<CommentBasic> getComments();
}
