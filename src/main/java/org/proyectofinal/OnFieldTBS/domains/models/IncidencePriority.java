package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IncidencePriority {
    LOW("Baja"),
    MID("Media"),
    HIGH("Alta");

    private final String priority;

    IncidencePriority(String priority) {
        this.priority = priority;
    }

    @JsonValue
    public String getValue(){
        return priority;
    }
}
