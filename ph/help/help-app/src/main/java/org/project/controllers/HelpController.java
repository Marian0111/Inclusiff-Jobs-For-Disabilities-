package org.project.controllers;

import lombok.RequiredArgsConstructor;
import org.project.api.HelpApi;
import org.project.dtos.ResponseMessage;
import org.project.dtos.TrainingDto;
import org.project.dtos.TrainingRegisterRequest;
import org.project.services.HelpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class HelpController implements HelpApi {
    private final HelpService helpService;

    @Override
    public ResponseEntity<ResponseMessage> registerToTraining(TrainingRegisterRequest request) {
        try {
            return ResponseEntity.ok(helpService.registerToTraining(request));
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body(ResponseMessage.builder().message(ex.getMessage()).build());
        }

    }

    @Override
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        return ResponseEntity.ok(helpService.getAllTrainings());
    }

    @Override
    public ResponseEntity<List<UUID>> getTrainingParticipants(UUID trainingExternalId) {
        return ResponseEntity.ok(helpService.getTrainingParticipants(trainingExternalId));
    }

    @Override
    public ResponseEntity<List<TrainingDto>> getUserTrainings(UUID userExternalId) {
        return ResponseEntity.ok(helpService.getUserTrainings(userExternalId));
    }
}
