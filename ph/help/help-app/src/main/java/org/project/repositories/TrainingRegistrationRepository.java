package org.project.repositories;

import org.project.entities.TrainingRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TrainingRegistrationRepository extends JpaRepository<TrainingRegistrationEntity, Integer> {
    List<TrainingRegistrationEntity> findAllByTrainingExternalId(UUID trainingExternalId);
    List<TrainingRegistrationEntity> findAllByUserExternalId(UUID userExternalId);
}
