package org.proyectofinal.OnFieldTBS.domains.models;

public enum IncidenceStatus {
    OPEN("Abierto"),
    IN_PROGRESS("En progreso"),
    PAUSED("Pausado"),
    CLOSED("Cerrado");

    private final String status;

    IncidenceStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
