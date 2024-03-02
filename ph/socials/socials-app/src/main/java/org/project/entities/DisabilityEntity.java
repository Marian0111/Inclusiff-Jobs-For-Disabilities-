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
@Table(name = "DISABILITY")
@Builder
public class DisabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disability_id")
    private Integer disabilityId;

    @Column(name = "disability_name", nullable = false)
    private String disabilityName;

    @Column(name = "disability_external_id", nullable = false, unique = true)
    private UUID disabilityExternalId;

}
