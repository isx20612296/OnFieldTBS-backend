package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "technician")
@NoArgsConstructor
@Data
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private boolean license;
    private String phone;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="level_id")
    @JsonIgnoreProperties("technicians")
    private Level level;

    @OneToMany(mappedBy = "technician")
    @JsonIgnoreProperties("technician")
    private Set<Incidence> incidences;

    @OneToMany(mappedBy = "technician")
    @JsonIgnoreProperties("technician")
    private Set<Comment> comments;


}
