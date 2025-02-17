package com.votation.api.service;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.exception.BadRequestException;
import com.votation.api.repository.ScheduleRepository;
import com.votation.api.validation.ScheduleValidator;


import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleValidator scheduleValidator;

    public ScheduleEntity postSchedule(ScheduleEntity scheduleEntity){

        //TODO: Criar camada(package) de validator e migrar essa função
        if (scheduleEntity.getDescription().isEmpty()) {
            throw new BadRequestException("Description missing");
        }

        return scheduleRepository.save(scheduleEntity);
    }

    public List<ScheduleEntity> getAllSchedules() {
        //TODO: Implementar tratamento de erro para pautas inexistentes
        return scheduleRepository.findAll();
    }

    public ScheduleEntity getScheduleById(UUID id) {
         return findScheduleById(id);
    }


    public ScheduleEntity startVotingSession(ScheduleEntity scheduleEntity) {
        var response = scheduleRepository.findById(scheduleEntity.getId());

        if (response.isPresent()) {
            return scheduleRepository.save(scheduleValidator.verifyNullDeadline(response.get()));
        } else {
            throw new ObjectNotFoundException(scheduleEntity.getId(), ScheduleEntity.class.getSimpleName());
        }

    }

    private ScheduleEntity findScheduleById(UUID id) {
        return scheduleRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, ScheduleEntity.class.getSimpleName()));
    }

}
