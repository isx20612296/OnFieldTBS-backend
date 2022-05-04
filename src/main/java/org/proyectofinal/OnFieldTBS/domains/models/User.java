package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usser")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String username;
    private String password;
    private String role;
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties({"user", "level", "incidences","comments"})
    private Technician technician;


}
