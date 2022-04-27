package org.proyectofinal.OnFieldTBS.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
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

    @ManyToOne
    @JoinColumn(name = "id_plan_mantenimiento")
    @JsonIgnoreProperties("empresas")
    private PlanMantenimiento planMantenimiento;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnoreProperties("empresa")
    private Set<Empleado> empleados;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnoreProperties("empresa")
    private Set<Incidencia> incidencias;

}
