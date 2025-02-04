package com.votation.api.controller;

import com.votation.api.dto.VoteResultDto;
import com.votation.api.entity.ScheduleEntity;
import com.votation.api.entity.VoteEntity;
import com.votation.api.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @Operation(summary = "Post new vote", description = "Add a new vote from the user to a specific schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vote added successfully",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = VoteEntity.class)))
    })
    @PostMapping
    public VoteEntity postVote(@RequestBody VoteEntity voteEntity) {
        return voteService.postVote(voteEntity);
    }

    @Operation(summary = "Get schedule voting result", description = "Calculate a result for a schedule voting if the voting is already over")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Schedule results returned successfully"),
    })
    @GetMapping("/result/{idSchedule}")
    public VoteResultDto getScheduleResult(@PathVariable UUID idSchedule) {
        return voteService.calculateVoteResult(idSchedule);
    }

}
