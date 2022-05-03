package org.proyectofinal.OnFieldTBS.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"userId", "username", "enabled"})
public interface UserBasic {

     UUID getUserId();
     String getUsername();
     boolean isEnabled();
     
}
