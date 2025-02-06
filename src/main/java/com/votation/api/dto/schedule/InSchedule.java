package com.votation.api.dto.schedule;

import java.time.LocalDateTime;


public class InSchedule {
    private String description;
    private LocalDateTime deadline;

    public InSchedule(String description, LocalDateTime deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
