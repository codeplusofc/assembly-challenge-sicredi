package com.votation.api.dto.vote;

public class OutVote {
    private String scheduleDescription;
    private String userName;
    private boolean vote;

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isVote() {
        return vote;
    }
}
