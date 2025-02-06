package com.votation.api.service;

import com.votation.api.dto.VoteResultDto;
import com.votation.api.entity.ScheduleEntity;
import com.votation.api.entity.VoteEntity;
import com.votation.api.repository.ScheduleRepository;
import com.votation.api.repository.VoteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public VoteEntity postVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }

    public VoteResultDto calculateVoteResult(UUID idSchedule) {
        var votes = voteRepository.findByIdSchedule(idSchedule);

        int yes = 0;
        int no = 0;
        String result = "result";

        for (int i = 0; i < votes.size(); i++) {
            if (votes.get(i).isVote()) {
                yes++;
            } else {
                no++;
            }
        }

        if (yes > no) {
            result = "Approved";
        } else if (yes < no) {
            result = "Rejected";
        } else {
            result = "Tie";
        }

        return new VoteResultDto(idSchedule, yes, no, result);
    }

}
