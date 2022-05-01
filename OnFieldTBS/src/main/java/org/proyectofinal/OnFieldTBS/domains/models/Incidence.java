package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "incidence")
@NoArgsConstructor
@Data
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private IncidenceStatus state;
    @Enumerated(value = EnumType.STRING)
    private IncidencePriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("incidences")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties("incidences")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    @JsonIgnoreProperties("incidences")
    private Technician technician;


    @OneToMany(mappedBy = "incidence")
    @JsonIgnoreProperties("incidence")
    private Set<Comment> comments;


}
