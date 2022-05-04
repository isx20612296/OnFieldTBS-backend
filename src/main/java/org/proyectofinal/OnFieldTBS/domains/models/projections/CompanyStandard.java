package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id", "name", "nif", "address", "phone", "email"})
public interface CompanyStandard {

     UUID getId();
     String getName();
     String getNif();
     String getAddress();
     String getPhone();
     String getEmail();
//     int getNumberOfEmployees();
//     int getNumberOfIncidences();
     MaintenanceIn getMaintenance();


}
