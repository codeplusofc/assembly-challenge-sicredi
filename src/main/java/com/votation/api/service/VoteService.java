package com.votation.api.service;

import com.votation.api.entity.VoteEntity;
import com.votation.api.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public VoteEntity postVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }

    public List<VoteEntity> getAllVotes() {
        return voteRepository.findAll();
    }

    public VoteEntity getVoteById(UUID id) {
        var response = voteRepository.findById(id);
        if (response.isEmpty()) {
            throw new RuntimeException("Voto não encontrato");
        }

        return response.get();
    }
}
