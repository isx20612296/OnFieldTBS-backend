package org.proyectofinal.OnFieldTBS.domains.dtos;

import java.util.Set;
import java.util.UUID;

public class ResponseLocation {

    public String companyName;

    public String address;
    public Location location;
   public Set<UUID> incidencesList;

    public ResponseLocation() {
        this.location = new Location();
    }
}
