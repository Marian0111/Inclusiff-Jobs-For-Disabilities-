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
@Table(name = "EVENT_INTEREST")
@Builder
public class EventInterestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_interest_id")
    private Integer eventInterestId;

    @Column(name = "event_external_id", nullable = false)
    private UUID eventExternalId;

    @Column(name = "disability_external_id", nullable = false)
    private UUID disabilityExternalId;
}
