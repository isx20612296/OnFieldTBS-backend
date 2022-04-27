package org.proyectofinal.OnFieldTBS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
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

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties("incidencias")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @JsonIgnoreProperties("incidencias")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    @JsonIgnoreProperties("incidencias")
    private Tecnico tecnico;


    @OneToMany(mappedBy = "incidencia")
    @JsonIgnoreProperties("incidencia")
    private Set<ComentarioIncidencia> comentarios;


}
