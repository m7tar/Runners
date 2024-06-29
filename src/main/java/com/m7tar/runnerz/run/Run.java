package com.m7tar.runnerz.run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        @Positive
        Integer id,
        @NotEmpty
        String tittle,
        LocalDateTime startedOn,
        LocalDateTime CompletedOn,
        @Positive
        Integer kilometers,
        Location location
) {
    public Run {
        if (!CompletedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after started On");
        }
    }
}
