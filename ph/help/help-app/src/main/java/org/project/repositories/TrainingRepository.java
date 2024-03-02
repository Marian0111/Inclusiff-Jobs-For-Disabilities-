package org.project.repositories;

import org.project.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
    Optional<TrainingEntity> findByTrainingExternalId(UUID trainingExternalId);
}
