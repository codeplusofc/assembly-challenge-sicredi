package com.votation.api.service;

import com.votation.api.entity.AgendaEntity;
import com.votation.api.entity.UserEntity;
import com.votation.api.repository.AgendaRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendaService {
    private AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public AgendaEntity postAgenda(AgendaEntity agendaEntity){
        return agendaRepository.save(agendaEntity);
    }

    public List<AgendaEntity> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Optional<AgendaEntity> getAgendaById(UUID id) {
        return agendaRepository.findById(id);
    }
}
