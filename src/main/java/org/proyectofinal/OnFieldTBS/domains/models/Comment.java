package org.proyectofinal.OnFieldTBS.domains.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String message;
    private LocalDateTime createdAt;

   @ManyToOne
   @JoinColumn(name = "incidence_id")
   @JsonIgnoreProperties({"comments", "company", "employee", "technician"})
   private Incidence incidence;

   @ManyToOne
   @JoinColumn(name = "technician_id")
   @JsonIgnoreProperties({"comments", "incidences"})
   private Technician technician;
}
