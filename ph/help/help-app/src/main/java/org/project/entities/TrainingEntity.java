package org.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRAINING")
@Builder
public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Integer trainingId;

    @Column(name = "description")
    private String description;

    @Column(name = "training_external_id")
    private UUID trainingExternalId;

    @PrePersist
    void prePersist() {
        if (trainingExternalId == null) {
            trainingExternalId = UUID.randomUUID();
        }
    }
}
