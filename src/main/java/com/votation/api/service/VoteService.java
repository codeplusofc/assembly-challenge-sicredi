package com.votation.api.service;

import com.votation.api.dto.vote.OutVoteResult;
import com.votation.api.entity.VoteEntity;
import com.votation.api.repository.ScheduleRepository;
import com.votation.api.repository.VoteRepository;
import com.votation.api.validation.VoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private VoteValidator voteValidator;

    //TODO: Criar camada mapper para as funcionalidades de voto

    public VoteEntity postVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }

    public OutVoteResult calculateVoteResult(UUID idSchedule) {
        var votes = voteRepository.findByIdSchedule(idSchedule);

       int yesVotes = scheduleYesVoteCounter(votes);
       int noVotes = votes.size() - yesVotes;

        String result = voteValidator.ValidateVoteResult(yesVotes, noVotes);

        return new OutVoteResult(idSchedule, yesVotes, noVotes, result);
    }

    //TODO: Implementar uma abordagem mais elegante para percorrer a lista de votos
    private int scheduleYesVoteCounter (List<VoteEntity> votes) {
        int yesVotes = 0;

        for (int i = 0; i < votes.size(); i++){
            if (votes.get(i).isVote()) {
                yesVotes++;
            }
        }

        return yesVotes;
    }
}
