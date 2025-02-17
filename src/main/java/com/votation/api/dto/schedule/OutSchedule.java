package com.votation.api.dto.schedule;

import java.time.LocalDateTime;

public class OutSchedule {
    private String description;
    private LocalDateTime deadline;

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}
