package org.project.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.project.dtos.ResponseMessage;
import org.project.dtos.TrainingDto;
import org.project.dtos.TrainingRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
public interface HelpApi {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/trainings/register", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseMessage> registerToTraining(@RequestBody @Valid TrainingRegisterRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TrainingDto>> getAllTrainings();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/training/{trainingExternalId}/participants")
    ResponseEntity<List<UUID>> getTrainingParticipants(@PathVariable @NotNull UUID trainingExternalId);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/user/{userExternalId}/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TrainingDto>> getUserTrainings(@PathVariable @NotNull UUID userExternalId);
}
