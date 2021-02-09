package com.dreamteam.motywatory.service;

import com.dreamteam.motywatory.model.dao.DemotEntity;
import com.dreamteam.motywatory.model.dao.VoteEntity;
import com.dreamteam.motywatory.model.dto.VoteDTO.CreateVoteRequest;
import com.dreamteam.motywatory.repository.DemotRepo;
import com.dreamteam.motywatory.repository.VoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepo voteRepo;
    private final DemotRepo demotRepo;

    @Transactional
    public void createVoteRequest(CreateVoteRequest request, Long demotId) {
        VoteEntity voteEntity = new VoteEntity();
        DemotEntity demotEntity = demotRepo.findById(demotId).orElseThrow(() -> new RuntimeException("nie mamy pana Demota i co nam Pan zrobi?"));
        voteEntity.setVote(request.getVote());
        voteEntity.setDemotId(demotEntity);
        voteEntity = voteRepo.save(voteEntity);
        demotEntity.getVoteId().add(voteEntity);

    }


}
