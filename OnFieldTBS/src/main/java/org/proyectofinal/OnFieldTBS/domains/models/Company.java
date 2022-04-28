package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "company")
@NoArgsConstructor
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String nif;
    private String address;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "maintenance_id")
    @JsonIgnoreProperties("companies")
    private Maintenance maintenance;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private Set<Incidence> incidences;

}
