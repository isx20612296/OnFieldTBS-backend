package org.proyectofinal.OnFieldTBS.domains.dtos;

import java.time.LocalDateTime;
import java.util.UUID;


public class RequestIncidence {

    public String title;
    public String description;
    public String state;
    public String priority;
    public LocalDateTime closedAt;
}
