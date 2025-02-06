package com.votation.api.service;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.exception.BadRequestException;
import com.votation.api.repository.ScheduleRepository;


import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleEntity postSchedule(ScheduleEntity scheduleEntity){
        if (scheduleEntity.getDescription().isEmpty()) {
            throw new BadRequestException("Description missing");
        }

        return scheduleRepository.save(scheduleEntity);
    }

    public List<ScheduleEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public ScheduleEntity getScheduleById(UUID id) {
        var response = scheduleRepository.findById(id);
         if (response.isEmpty()) {
             throw new ObjectNotFoundException(id, ScheduleEntity.class.getSimpleName());
         }
         return response.get();
    }


    public ScheduleEntity startVotingSession(ScheduleEntity scheduleEntity) {
        var response = scheduleRepository.findById(scheduleEntity.getId());
        var date = LocalDateTime.now();

        if (response.isPresent()) {
            if (response.get().getDeadline() == null) {
                if (scheduleEntity.getDeadline() != null) {
                    response.get().setDeadline(scheduleEntity.getDeadline());
                    return scheduleRepository.save(response.get());
                } else {
                    response.get().setDeadline(date.plusMinutes(1));
                    return scheduleRepository.save(response.get());
                }
            }

        }

        throw new RuntimeException("Non existing schedule");

    }



}
