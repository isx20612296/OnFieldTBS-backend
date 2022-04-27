package org.proyectofinal.OnFieldTBS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comentario_incidencia")
public class ComentarioIncidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_comentario;
    private String mensaje;
    private LocalDateTime fecha_creacion;

   @ManyToOne
   @JoinColumn(name = "id_incidencia")
   @JsonIgnoreProperties("comentarios")
   private Incidencia incidencia;

   @ManyToOne
   @JoinColumn(name = "id_tecnico")
   @JsonIgnoreProperties("comentarios")
   private Tecnico tecnico;
}
