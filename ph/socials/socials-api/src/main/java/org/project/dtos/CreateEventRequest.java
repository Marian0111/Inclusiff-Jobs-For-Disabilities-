package org.project.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventRequest {
    @NotBlank
    private String eventName;

    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate eventDate;

    @NotBlank
    private String eventAddress;

    @NotNull
    private UUID organizerId;

    @NotNull
    private List<String> interests;
}
