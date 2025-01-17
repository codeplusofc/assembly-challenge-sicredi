package com.votation.api.controller;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    @GetMapping
    public List<ScheduleEntity> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleEntity getScheduleById(@PathVariable UUID id) {
        return scheduleService.getScheduleById(id);
    }

    @PostMapping
    public ScheduleEntity postSchedule(@RequestBody ScheduleEntity scheduleEntity) {
        return scheduleService.postSchedule(scheduleEntity);
    }


}
