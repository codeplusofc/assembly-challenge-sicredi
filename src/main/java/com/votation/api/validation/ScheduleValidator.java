package com.votation.api.validation;

import com.votation.api.entity.ScheduleEntity;
import com.votation.api.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
public class ScheduleValidator {
    @Autowired
    private ScheduleRepository scheduleRepository;

    //TODO: Lógica incorreta, precisa arrumar
    public ScheduleEntity verifyNullDeadline(ScheduleEntity scheduleEntity) {
        var response = scheduleRepository.findById(scheduleEntity.getId());

        if (response.get().getDeadline() == null) {
            //TODO: Validar se o prazo que está vindo na pauta da abertura de sessão está nulo
            response.get().setDeadline(scheduleEntity.getDeadline());
        } else {
            setDeadlineSession(response);
        }

        return response.get();
    }

    public Optional<ScheduleEntity> setDeadlineSession(Optional<ScheduleEntity> scheduleEntity) {
        var date = now();
        var deadline = date.plusMinutes(1);

        scheduleEntity.get().setDeadline(deadline);
        return scheduleEntity;
    }
}
