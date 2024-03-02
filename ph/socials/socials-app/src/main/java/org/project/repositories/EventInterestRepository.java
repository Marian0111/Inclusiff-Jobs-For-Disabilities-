package org.project.repositories;

import org.project.entities.EventEntity;
import org.project.entities.EventInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventInterestRepository extends JpaRepository<EventInterestEntity, Integer> {
    List<EventInterestEntity> findAllByEventExternalId(UUID eventExternalId);
}
