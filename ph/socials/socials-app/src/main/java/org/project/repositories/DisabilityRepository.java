package org.project.repositories;

import org.project.entities.DisabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisabilityRepository extends JpaRepository<DisabilityEntity, Integer> {
    Optional<DisabilityEntity> findByDisabilityName(String name);
    Optional<DisabilityEntity> findByDisabilityExternalId(UUID disabilityExternalId);
}
