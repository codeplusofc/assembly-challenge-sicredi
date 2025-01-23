package com.votation.api.service;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.exception.BadRequestException;
import com.votation.api.repository.ScheduleRepository;


import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
