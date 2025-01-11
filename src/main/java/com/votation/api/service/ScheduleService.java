package com.votation.api.service;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.repository.ScheduleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleEntity postSchedule(ScheduleEntity scheduleEntity){
        return scheduleRepository.save(scheduleEntity);
    }

    public List<ScheduleEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public ScheduleEntity getScheduleById(UUID id) {
        var response = scheduleRepository.findById(id);
         if (response.isEmpty()) {
             throw new RuntimeException("Pauta não encontrada");
         }
         return response.get();
    }
}
