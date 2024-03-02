package org.project.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.project.dtos.JobOfferDto;
import org.project.dtos.JobOfferRequest;
import org.project.dtos.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
public interface EnterpriseApi {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/enterprise/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseMessage> postJobOffer(@RequestBody @Valid JobOfferRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/enterprise/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<JobOfferDto>> getJobOffers();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/enterprise/{enterpriseExternalId}/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<JobOfferDto>> getEnterpriseJobOffers(@PathVariable @NotNull UUID enterpriseExternalId);
}
