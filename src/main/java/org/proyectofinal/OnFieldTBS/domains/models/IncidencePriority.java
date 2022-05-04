package org.proyectofinal.OnFieldTBS.domains.models;

public enum IncidencePriority {
    LOW("Baja"),
    MID("Media"),
    HIGH("Alta");

    private final String priority;

    IncidencePriority(String priority) {
        this.priority = priority;
    }
    public String getPriority(){
        return priority;
    }
}
