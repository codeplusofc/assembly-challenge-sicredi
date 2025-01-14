package com.votation.api.controller;

import com.votation.api.entity.VoteEntity;
import com.votation.api.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    public List<VoteEntity> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/{id}")
    public VoteEntity getVoteById(@PathVariable UUID id) {
        return voteService.getVoteById(id);
    }

    @PostMapping
    public VoteEntity postVote(@RequestBody VoteEntity voteEntity) {
        return voteService.postVote(voteEntity);
    }
}
