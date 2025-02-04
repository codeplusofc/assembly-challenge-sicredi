package com.votation.api.controller;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Operation(summary = "Get a list of all schedules", description = "Return a list of all existent schdules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Schedule list successfully returned")
    })
    @GetMapping
    public List<ScheduleEntity> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @Operation(summary = "Find a schedule by it`s id", description = "Return the schedule with the searched id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Schedule successfully returned"),
            @ApiResponse(responseCode = "404", description = "Schedule with searched id not found")
    })
    @GetMapping("/{id}")
    public ScheduleEntity getScheduleById(@PathVariable UUID id) {
        return scheduleService.getScheduleById(id);
    }

    @Operation(summary = "Post new schedule", description = "Add a new schedule to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Schedule added successfully",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ScheduleEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, description is required")
    })
    @PostMapping
    public ScheduleEntity postSchedule(@RequestBody ScheduleEntity scheduleEntity) {
        return scheduleService.postSchedule(scheduleEntity);
    }



}
