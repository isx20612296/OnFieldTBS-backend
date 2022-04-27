package org.proyectofinal.OnFieldTBS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tecnico")
@NoArgsConstructor
@Data
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_tecnico;
    private String nombre;
    private String apellido;
    private String nombre_usuario;
    private String passwd;
    private String correo;
    private boolean tiene_carnet;
    private String telefono;

    @ManyToOne
    @JoinColumn(name="id_nivel")
    @JsonIgnoreProperties("tecnicos")
    private Nivel nivel;

    @OneToMany(mappedBy = "tecnico")
    @JsonIgnoreProperties("tecnico")
    private Set<Incidencia> incidencias;

    @OneToMany(mappedBy = "tecnico")
    @JsonIgnoreProperties("tecnico")
    private List<ComentarioIncidencia> comentarios;


}
