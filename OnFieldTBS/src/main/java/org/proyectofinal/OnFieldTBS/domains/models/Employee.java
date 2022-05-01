package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String lastname;
    private String phoneExt;
    private String directPhone;
    private String email;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("employees")
    private Company company;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    private Set<Incidence> incidences;


}
