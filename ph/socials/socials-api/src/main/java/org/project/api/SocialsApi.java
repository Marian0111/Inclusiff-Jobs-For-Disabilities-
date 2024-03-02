package org.project.api;

import jakarta.validation.Valid;
import org.project.dtos.CreateEventRequest;
import org.project.dtos.EventDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface SocialsApi {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EventDto> createEvent(@RequestBody @Valid CreateEventRequest createEventRequest);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EventDto>> getAllEvents();
}
