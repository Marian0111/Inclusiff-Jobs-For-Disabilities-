package org.project.controllers;

import lombok.RequiredArgsConstructor;
import org.project.api.SocialsApi;
import org.project.dtos.CreateEventRequest;
import org.project.dtos.EventDto;
import org.project.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class SocialsController implements SocialsApi {
    private final EventService eventService;

    @Override
    public ResponseEntity<EventDto> createEvent(CreateEventRequest createEventRequest) {
        return ResponseEntity.ok(eventService.createEvent(createEventRequest));
    }

    @Override
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
