package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description","employee", "company","technician","state", "priority", "createdAt", "closedAt"})
public interface IncidenceDetail {
     UUID getId();
     String getTitle();
     String getDescription();
     String getState();
     String getPriority();
     LocalDateTime getCreatedAt();
     LocalDateTime getClosedAt();


     CompanyIn getCompany();
     EmployeeIn getEmployee();
     TechnicianIn getTechnician();
     Set<CommentBasic> getComments();
}
