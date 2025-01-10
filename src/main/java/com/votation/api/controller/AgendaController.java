package com.votation.api.controller;

import com.votation.api.entity.AgendaEntity;
import com.votation.api.entity.UserEntity;
import com.votation.api.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<AgendaEntity> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    @GetMapping("/{id}")
    public Optional<AgendaEntity> getAgendaById(@PathVariable UUID id) {
        return agendaService.getAgendaById(id);
    }

    @PostMapping
    public AgendaEntity postAgenda(@RequestBody AgendaEntity agendaEntity) {
        return agendaService.postAgenda(agendaEntity);
    }
}
