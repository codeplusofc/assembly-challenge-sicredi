package com.votation.api.dto.vote;

public class OutVote {
    private String scheduleDescription;
    private String userName;
    private boolean vote;

    public OutVote(String scheduleDescription, String userName, boolean vote) {
        this.scheduleDescription = scheduleDescription;
        this.userName = userName;
        this.vote = vote;
    }

    //For output only getters
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
