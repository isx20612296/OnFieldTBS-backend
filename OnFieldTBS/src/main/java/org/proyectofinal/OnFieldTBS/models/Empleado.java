package org.proyectofinal.OnFieldTBS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_empleado;
    private String nombre;
    private String apellido;
    private String ext_telefono;
    private String telefono_directo;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties("empleados")
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")
    @JsonIgnoreProperties("empleado")
    private Set<Incidencia> incidencias;

}
