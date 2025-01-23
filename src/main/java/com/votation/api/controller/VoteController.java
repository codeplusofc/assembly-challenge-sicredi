package com.votation.api.controller;

import com.votation.api.dto.VoteResultDto;
import com.votation.api.entity.VoteEntity;
import com.votation.api.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping
    public VoteEntity postVote(@RequestBody VoteEntity voteEntity) {
        return voteService.postVote(voteEntity);
    }

    @GetMapping("/result/{idSchedule}")
    public VoteResultDto getScheduleResult(@PathVariable UUID idSchedule) {
        return voteService.calculateVoteResult(idSchedule);
    }

}
