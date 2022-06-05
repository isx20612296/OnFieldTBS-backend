package org.proyectofinal.OnFieldTBS.utils.converters;

import org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus.*;

@Converter(autoApply = true)
public class IncidenceStatusConverter  implements AttributeConverter<IncidenceStatus, String> {
    @Override
    public String convertToDatabaseColumn(IncidenceStatus incidenceStatus) {
        switch (incidenceStatus){
            case OPEN:
                return OPEN.getValue();
            case WORKING:
                return WORKING.getValue();
            case PAUSED:
                return PAUSED.getValue();
            case CLOSED:
                return CLOSED.getValue();
            default:
                throw new IllegalArgumentException("IncidenceStatus ["+ incidenceStatus+"] not supported.");
        }
    }

    @Override
    public IncidenceStatus convertToEntityAttribute(String dbStatus) {
        switch (dbStatus){
            case "Abierta":
                return OPEN;
            case "En progreso":
                return WORKING;
            case "Pausada":
                return PAUSED;
            case "Cerrada":
                return CLOSED;
            default:
                throw new IllegalArgumentException("IncidenceStatus ["+dbStatus+"] not supported.");
        }
    }
}
