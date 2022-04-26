package org.proyectofinal.OnFieldTBS.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "empresa")
@NoArgsConstructor
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_empresa;
    private String nombre;
    private String nif;
    private String direccion;
    private String telefono;
    private String correo;

}
