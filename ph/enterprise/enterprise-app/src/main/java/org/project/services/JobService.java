package org.project.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.project.dtos.JobOfferDto;
import org.project.dtos.JobOfferRequest;
import org.project.dtos.ResponseMessage;
import org.project.repositories.JobRepository;
import org.project.services.mappers.JobMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper = Mappers.getMapper(JobMapper.class);

    public ResponseMessage saveJobOffer(JobOfferRequest request) {
        jobRepository.save(jobMapper.toEntity(request));

        return ResponseMessage.builder()
                .message("Job added successfully!")
                .build();
    }

    public List<JobOfferDto> getAllJobs() {
        return jobRepository.findAll().stream().map(jobMapper::toDto).toList();
    }

    public List<JobOfferDto> getAllEnterpriseJobs(UUID enterpriseExternalId) {
        return jobRepository.findAllByEnterpriseId(enterpriseExternalId).stream().map(jobMapper::toDto).toList();
    }
}
