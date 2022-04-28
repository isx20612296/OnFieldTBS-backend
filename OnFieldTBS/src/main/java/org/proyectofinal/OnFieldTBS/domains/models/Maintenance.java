package org.proyectofinal.OnFieldTBS.domains.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity()
@Table(name = "maintenance_plan")
@NoArgsConstructor
@Data
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
