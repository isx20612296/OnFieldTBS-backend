package org.proyectofinal.OnFieldTBS.domains.dtos;


import org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority;
import org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus;

import java.util.UUID;

public class RequestIncidence {
    public IncidenceStatus status;
    public IncidencePriority priority;
    public String technicianUsername;
}
