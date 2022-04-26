package org.proyectofinal.OnFieldTBS.models;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nivel", referencedColumnName = "referencedColumnName")
    private Nivel nivel;
}
