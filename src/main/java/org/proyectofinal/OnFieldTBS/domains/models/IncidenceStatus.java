package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IncidenceStatus {
    OPEN("Abierta"),
    WORKING("En progreso"),
    PAUSED("Pausada"),
    CLOSED("Cerrada");

    private final String status;

    IncidenceStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getValue(){
        return status;
    }
}
