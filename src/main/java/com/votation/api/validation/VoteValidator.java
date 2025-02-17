package com.votation.api.validation;

import com.votation.api.entity.VoteEntity;
import com.votation.api.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteValidator {
    @Autowired
    private VoteRepository voteRepository;

    public String ValidateVoteResult(int yes, int no) {
        String voteResult;

        if (yes > no) {
            voteResult = "Approved";
        } else if (yes < no) {
            voteResult = "Rejected";
        } else {
            voteResult = "Tie";
        }

        return voteResult;
    }
}
