package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "technician")
@NoArgsConstructor
@Getter
@Setter
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private boolean license;
    private String phone;
    private LocalDate createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"technician"})
    private User user;

    @ManyToOne
    @JoinColumn(name="level_id")
    @JsonIgnoreProperties("technicians")
    private Level level;

    @OneToMany(mappedBy = "technician")
    @JsonIgnoreProperties({"technician", "company", "employee", "comments"})
    private Set<Incidence> incidences;

    @OneToMany(mappedBy = "technician")
    @JsonIgnoreProperties({"technician", "incidence"})
    private Set<Comment> comments;


}
