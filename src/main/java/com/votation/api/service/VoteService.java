package com.votation.api.service;

import com.votation.api.dto.vote.OutVoteResult;
import com.votation.api.entity.VoteEntity;
import com.votation.api.repository.ScheduleRepository;
import com.votation.api.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    //TODO: Criar camada mapper para as funcionalidades de voto

    public VoteEntity postVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }

    public OutVoteResult calculateVoteResult(UUID idSchedule) {
        var votes = voteRepository.findByIdSchedule(idSchedule);

        int yes = 0;
        int no = 0;
        String result = "result";

        //TODO: Migrar essa lógica de contabilidade de votos para uma nova função
        //TODO: Implementar uma abordagem mais elegante para percorrer a lista de votos
        for (int i = 0; i < votes.size(); i++) {
            if (votes.get(i).isVote()) {
                yes++;
            } else {
                no++;
            }
        }

        //TODO: Migrar essa lógica de validação do resultado para uma nova função
        if (yes > no) {
            result = "Approved";
        } else if (yes < no) {
            result = "Rejected";
        } else {
            result = "Tie";
        }

        return new OutVoteResult(idSchedule, yes, no, result);
    }

}
