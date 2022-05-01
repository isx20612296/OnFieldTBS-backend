package org.proyectofinal.OnFieldTBS.domains.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity()
@Table(name = "maintenance_plan")
@NoArgsConstructor
@Getter
@Setter
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private Double price;

    @OneToMany(mappedBy = "maintenance")
    @JsonIgnoreProperties("maintenance")
    private Set<Company> companies;

}
