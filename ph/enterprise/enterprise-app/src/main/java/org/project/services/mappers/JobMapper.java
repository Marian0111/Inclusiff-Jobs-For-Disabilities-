package org.project.services.mappers;

import org.mapstruct.Mapper;
import org.project.dtos.JobOfferDto;
import org.project.dtos.JobOfferRequest;
import org.project.entities.JobEntity;

@Mapper
public interface JobMapper {
    JobOfferDto toDto(JobEntity jobEntity);
    JobEntity toEntity(JobOfferRequest jobOfferRequest);
}
