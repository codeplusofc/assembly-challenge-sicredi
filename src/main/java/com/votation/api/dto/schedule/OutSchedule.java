package com.votation.api.dto.schedule;

import java.time.LocalDateTime;

public class OutSchedule {
    private String description;
    private LocalDateTime deadline;

    public OutSchedule(String description, LocalDateTime deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    //For output only getters
    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}
