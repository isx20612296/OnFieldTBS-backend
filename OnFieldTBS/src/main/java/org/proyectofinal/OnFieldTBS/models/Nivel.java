package org.proyectofinal.OnFieldTBS.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "nivel")
@NoArgsConstructor
@Data
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_nivel;
    private String nombre;
    private String descripcion;
}