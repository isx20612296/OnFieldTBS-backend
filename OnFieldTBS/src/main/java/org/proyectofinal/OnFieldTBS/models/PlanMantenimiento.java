package org.proyectofinal.OnFieldTBS.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity()
@Table(name = "plan_mantenimiento")
@NoArgsConstructor
@Data
public class PlanMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_plan;
    private String nombre;
    private String descripcion;
    private Double precio;

    @OneToMany(mappedBy = "planMantenimiento")
    @JsonIgnoreProperties("planMantenimiento")
    private Set<Empresa> empresas;

}
