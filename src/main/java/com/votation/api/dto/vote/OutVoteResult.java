package com.votation.api.dto.vote;


import java.util.UUID;

public class OutVoteResult {
    private UUID idSchedule;
    private int yesVotes;
    private int noVotes;
    private String result;

    public OutVoteResult(UUID idSchedule, int yesVotes, int noVotes, String result) {
        this.idSchedule = idSchedule;
        this.yesVotes = yesVotes;
        this.noVotes = noVotes;
        this.result = result;
    }

    public UUID getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(UUID idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getYesVotes() {
        return yesVotes;
    }

    public void setYesVotes(int yesVotes) {
        this.yesVotes = yesVotes;
    }

    public int getNoVotes() {
        return noVotes;
    }

    public void setNoVotes(int noVotes) {
        this.noVotes = noVotes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
