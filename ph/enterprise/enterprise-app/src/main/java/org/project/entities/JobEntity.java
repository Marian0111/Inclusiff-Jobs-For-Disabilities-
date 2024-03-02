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
@Table(name = "JOB")
@Builder
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_external_id")
    private UUID jobExternalId;

    @Column(name = "enterprise_id")
    private UUID enterpriseId;

    @PrePersist
    void prePersist() {
        if (jobExternalId == null) {
            jobExternalId = UUID.randomUUID();
        }
    }
}
