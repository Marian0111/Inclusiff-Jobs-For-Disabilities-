package org.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private String eventName;
    private LocalDate eventDate;
    private String eventAddress;
    private UUID organizerId;
    private List<String> interests;
    private UUID eventExternalId;
}
