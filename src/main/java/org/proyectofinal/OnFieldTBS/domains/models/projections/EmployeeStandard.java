package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "lastname", "phoneExt", "directPhone", "email", "createdAt", "company"})
public interface EmployeeStandard {

     UUID getId();
     String getName();
     String getLastname();
     String getPhoneExt();
     String getDirectPhone();
     String getEmail();
     LocalDateTime getCreatedAt();



     CompanyIn getCompany();
     IncidenceIn getIncidences();
}
