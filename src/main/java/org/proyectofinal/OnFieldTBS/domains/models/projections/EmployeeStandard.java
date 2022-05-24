package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "lastname", "phoneExt", "directPhone", "email", "company"})
public interface EmployeeStandard {

     UUID getId();
     String getName();
     String getLastname();
     String getPhoneExt();
     String getDirectPhone();
     String getEmail();



     CompanyIn getCompany();
     Set<IncidenceByTechnicianId> getIncidences();
}
