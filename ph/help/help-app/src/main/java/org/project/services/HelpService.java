package org.project.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.project.dtos.ResponseMessage;
import org.project.dtos.TrainingDto;
import org.project.dtos.TrainingRegisterRequest;
import org.project.entities.TrainingEntity;
import org.project.entities.TrainingRegistrationEntity;
import org.project.repositories.TrainingRegistrationRepository;
import org.project.repositories.TrainingRepository;
import org.project.services.mappers.TrainingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HelpService {
    private final TrainingRepository trainingRepository;
    private final TrainingRegistrationRepository trainingRegistrationRepository;
    private final TrainingMapper trainingMapper = Mappers.getMapper(TrainingMapper.class);

    @Transactional
    public ResponseMessage registerToTraining(TrainingRegisterRequest request) {
        if (getTrainingParticipants(request.getTrainingExternalId()).contains(request.getUserExternalId())) {
            throw new RuntimeException("You cannot register for the same training twice!");
        }
        trainingRegistrationRepository.save(TrainingRegistrationEntity.builder()
                .trainingExternalId(request.getTrainingExternalId())
                .userExternalId(request.getUserExternalId())
                .build());

        return ResponseMessage.builder()
                .message("Registered successfully!")
                .build();
    }

    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll().stream().map(trainingMapper::toDto).toList();
    }

    public List<UUID> getTrainingParticipants(UUID trainingExternalId) {
        return trainingRegistrationRepository.findAllByTrainingExternalId(trainingExternalId).stream()
                .map(TrainingRegistrationEntity::getUserExternalId).toList();
    }

    public List<TrainingDto> getUserTrainings(UUID userExternalId) {
        List<UUID> trainings =  trainingRegistrationRepository.findAllByUserExternalId(userExternalId).stream()
                .map(TrainingRegistrationEntity::getTrainingExternalId)
                .toList();

        List<TrainingDto> trainingDtoList = new ArrayList<>(trainings.stream().map((id) -> {
                    Optional<TrainingEntity> tr = trainingRepository.findByTrainingExternalId(id);
                    return tr.map(trainingMapper::toDto).orElse(null);
                }
        ).toList());

        List<TrainingDto> nulls = new ArrayList<>();
        for (TrainingDto t : trainingDtoList) {
            if (t == null) {
                nulls.add(t);
            }
        }

        trainingDtoList.removeAll(nulls);
        return trainingDtoList;
    }
}
