package com.votation.api.service;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.exception.BadRequestException;
import com.votation.api.repository.ScheduleRepository;


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
        //TODO: Migrar validação de pauta vazia para outra função
        var response = scheduleRepository.findById(id);
         if (response.isEmpty()) {
             throw new ObjectNotFoundException(id, ScheduleEntity.class.getSimpleName());
         }
         return response.get();
    }


    public ScheduleEntity startVotingSession(ScheduleEntity scheduleEntity) {
        //TODO: Migrar essa busca por pauta para uma nova função
        var response = scheduleRepository.findById(scheduleEntity.getId());
        var date = now();

        //TODO: Migrar validação de pauta presente para uma nova função
        if (response.isPresent()) {
            //TODO: Migrar validação da pauta do banco de dados com prazo nulo para uma nova função
            if (response.get().getDeadline() == null) {
                //TODO: Migrar validação da pauta com prazo diferente de nulo para uma nova função
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
