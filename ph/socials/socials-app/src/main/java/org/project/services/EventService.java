package org.project.services;

import org.project.dtos.CreateEventRequest;
import org.project.dtos.EventDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.project.entities.DisabilityEntity;
import org.project.entities.EventEntity;
import org.project.entities.EventInterestEntity;
import org.project.repositories.DisabilityRepository;
import org.project.repositories.EventInterestRepository;
import org.project.repositories.EventRepository;
import org.project.services.mappers.EventMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventService {
    private final EventRepository eventRepository;
    private final DisabilityRepository disabilityRepository;
    private final EventInterestRepository eventInterestRepository;
    private final EventMapper eventMapper = Mappers.getMapper(EventMapper.class);

    @Transactional
    public EventDto createEvent(CreateEventRequest createEventRequest) {
        EventEntity savedEvent = saveEvent(createEventRequest);

        saveEventDisabilityMappings(savedEvent, createEventRequest);

        return toDto(savedEvent);
    }

    private void saveEventDisabilityMappings(EventEntity savedEvent, CreateEventRequest createEventRequest) {
        for (String disability : createEventRequest.getInterests()) {
            Optional<DisabilityEntity> optional = disabilityRepository.findByDisabilityName(disability);

            optional.ifPresent(disabilityEntity -> eventInterestRepository.save(EventInterestEntity.builder()
                            .eventExternalId(savedEvent.getEventExternalId())
                            .disabilityExternalId(disabilityEntity.getDisabilityExternalId())
                    .build()));
        }
    }

    private EventDto toDto(EventEntity savedEvent) {
        EventDto eventDto = eventMapper.toDto(savedEvent);

        eventDto.setInterests(eventInterestRepository
                .findAllByEventExternalId(savedEvent.getEventExternalId()).stream()
                .map(this::getDisabilityName)
                .toList());

        return eventDto;
    }

    private String getDisabilityName(EventInterestEntity eventInterest) {
        Optional<DisabilityEntity> disability = disabilityRepository
                .findByDisabilityExternalId(eventInterest.getDisabilityExternalId());

        if (disability.isPresent()) {
            return disability.get().getDisabilityName();
        }

        return "";
    }

    private EventEntity saveEvent(CreateEventRequest createEventRequest) {
        return eventRepository.save(EventEntity.builder()
                .eventName(createEventRequest.getEventName())
                .eventDate(createEventRequest.getEventDate())
                .eventAddress(createEventRequest.getEventAddress())
                .organizerId(createEventRequest.getOrganizerId())
                .build()
        );
    }

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream().map(this::toDto).toList();
    }
}
