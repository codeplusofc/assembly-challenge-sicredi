package com.votation.api.dto.vote;

public class InVote {
    private String scheduleDescription;
    private String userName;
    private boolean vote;

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}
