package org.project.services.mappers;

import org.project.dtos.EventDto;
import org.mapstruct.Mapper;
import org.project.entities.EventEntity;

@Mapper
public interface EventMapper {
    EventDto toDto(EventEntity event);
}
