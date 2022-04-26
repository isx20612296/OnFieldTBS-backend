package org.proyectofinal.OnFieldTBS.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "incidencia")
@NoArgsConstructor
@Data
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_incidencia;
    private String titulo;
    private String descripcion;
    private String estado;
    private String prioridad;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_cierre;
}
