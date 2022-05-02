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
@Table(name = "incidence")
@NoArgsConstructor
@Getter
@Setter
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String state;
    private String priority;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"incidences", "maintenance", "employees"})
    private Company company;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"incidences", "company"})
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    @JsonIgnoreProperties({"incidences", "comments"})
    private Technician technician;


    @OneToMany(mappedBy = "incidence")
    @JsonIgnoreProperties({"incidence", "technician"})
    private Set<Comment> comments;


}
