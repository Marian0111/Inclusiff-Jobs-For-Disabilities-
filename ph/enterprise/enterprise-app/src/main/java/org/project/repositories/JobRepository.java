package org.project.repositories;

import org.project.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {
    List<JobEntity> findAllByEnterpriseId(UUID externalEnterpriseId);
}
