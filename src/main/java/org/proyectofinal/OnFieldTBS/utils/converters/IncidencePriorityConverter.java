package org.proyectofinal.OnFieldTBS.utils.converters;

import org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static org.proyectofinal.OnFieldTBS.domains.models.IncidencePriority.*;

@Converter(autoApply = true)
public class IncidencePriorityConverter implements AttributeConverter<IncidencePriority, String> {
    @Override
    public String convertToDatabaseColumn(IncidencePriority incidencePriority) {
        switch (incidencePriority){
            case LOW:
                return LOW.getValue();
            case MID:
                return MID.getValue();
            case HIGH:
                return HIGH.getValue();
            default:
                throw new IllegalArgumentException("IncidencePriority ["+ incidencePriority+"] not supported.");
        }
    }

    @Override
    public IncidencePriority convertToEntityAttribute(String dbPriority) {
        switch (dbPriority){
            case "Baja":
                return LOW;
            case "Media":
                return MID;
            case "Alta":
                return HIGH;
            default:
                throw new IllegalArgumentException("IncidencePriority ["+dbPriority+"] not supported.");
        }
    }
}
