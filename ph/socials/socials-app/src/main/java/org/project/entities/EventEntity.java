package org.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EVENT")
@Builder
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "event_address", nullable = false)
    private String eventAddress;

    @Column(name = "event_organizer", nullable = false, unique = true)
    private UUID organizerId;

    @Column(name = "event_external_id", nullable = false, unique = true)
    private UUID eventExternalId;

    @PrePersist
    void prePersist() {
        if (eventExternalId == null) {
            eventExternalId = UUID.randomUUID();
        }
    }
}
