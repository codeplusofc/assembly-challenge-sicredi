package com.votation.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID idSchedule;
    private UUID idUser;
    private boolean vote;

    public UUID getId() {
        return id;
    }

    public UUID getIdSchedule() {
        return idSchedule;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public boolean isVote() {
        return vote;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setIdSchedule(UUID idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}
