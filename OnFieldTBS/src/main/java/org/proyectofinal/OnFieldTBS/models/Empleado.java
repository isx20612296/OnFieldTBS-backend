package org.proyectofinal.OnFieldTBS.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


}
