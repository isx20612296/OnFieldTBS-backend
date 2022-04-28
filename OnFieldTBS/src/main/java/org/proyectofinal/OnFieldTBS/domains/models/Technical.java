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
@Table(name = "technical")
@NoArgsConstructor
@Data
public class Technical {
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
    @JsonIgnoreProperties("technicals")
    private Level level;

    @OneToMany(mappedBy = "technical")
    @JsonIgnoreProperties("technical")
    private Set<Incidence> incidences;

    @OneToMany(mappedBy = "technical")
    @JsonIgnoreProperties("technical")
    private List<Comment> comments;


}
