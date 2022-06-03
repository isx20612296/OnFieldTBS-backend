package org.proyectofinal.OnFieldTBS.domains.dtos;

import org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority;
import org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus;

import java.time.LocalDateTime;
import java.util.UUID;


public class RequestIncidence {
    public String state;
    public String priority;
}
