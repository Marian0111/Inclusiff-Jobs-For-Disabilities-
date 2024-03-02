package org.project.services.mappers;

import org.mapstruct.Mapper;
import org.project.dtos.TrainingDto;
import org.project.entities.TrainingEntity;

@Mapper
public interface TrainingMapper {
    TrainingDto toDto(TrainingEntity trainingEntity);
}
