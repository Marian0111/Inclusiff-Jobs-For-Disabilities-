package org.project.controllers;

import lombok.RequiredArgsConstructor;
import org.project.api.EnterpriseApi;
import org.project.dtos.JobOfferDto;
import org.project.dtos.JobOfferRequest;
import org.project.dtos.ResponseMessage;
import org.project.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class JobController implements EnterpriseApi {
    private final JobService jobService;

    @Override
    public ResponseEntity<ResponseMessage> postJobOffer(JobOfferRequest request) {
        return ResponseEntity.ok(jobService.saveJobOffer(request));
    }

    @Override
    public ResponseEntity<List<JobOfferDto>> getJobOffers() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @Override
    public ResponseEntity<List<JobOfferDto>> getEnterpriseJobOffers(UUID enterpriseExternalId) {
        return ResponseEntity.ok(jobService.getAllEnterpriseJobs(enterpriseExternalId));
    }
}
