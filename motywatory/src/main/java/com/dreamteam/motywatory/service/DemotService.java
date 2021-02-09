package com.dreamteam.motywatory.service;

import com.dreamteam.motywatory.model.dao.DemotEntity;
import com.dreamteam.motywatory.model.dao.VoteEntity;
import com.dreamteam.motywatory.model.dto.DemotDTO.CreateDemotRequest;
import com.dreamteam.motywatory.model.dto.DemotDTO.GetAllDemotResponse;
import com.dreamteam.motywatory.model.dto.DemotDTO.ReadDemotResponse;
import com.dreamteam.motywatory.model.dto.VoteDTO.VoteCounter;
import com.dreamteam.motywatory.repository.DemotRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemotService {

    private final DemotRepo demotRepo;

    public void createDemotRequest(CreateDemotRequest request) {
        DemotEntity demotEntity = new DemotEntity();
        demotEntity.setTopText(request.getTopText());
        demotEntity.setImagePath(request.getImagePath());
        demotEntity.setBottomText(request.getBottomText());
        //demotEntity.setOwner(); //to juz na przyszlosc :D

        DemotEntity saveEntity = demotRepo.save(demotEntity);
    }

    public ReadDemotResponse readDemotResponse(Long id) {

        Optional<DemotEntity> demotEntity = demotRepo.findById(id);

        if (demotEntity.isPresent()) {
            ReadDemotResponse readDemotResponse = new ReadDemotResponse();
            readDemotResponse.setImagePath(demotEntity.get().getImagePath());
            readDemotResponse.setTopText(demotEntity.get().getTopText());
            readDemotResponse.setBottomText(demotEntity.get().getBottomText());
            readDemotResponse.setVote(demotEntity.get().getVoteId()
                    .stream().map(entity -> entity.getVote().toString()).collect(Collectors.toList()));

            return readDemotResponse;
        } else {
            throw new NoSuchElementException("nie ma takiego Demotywatora!");
        }
    }

    public GetAllDemotResponse getAllDemots() {
        return GetAllDemotResponse.builder()
                .demots(demotRepo.findAll().stream()
                        .map(demotEntity -> ReadDemotResponse.builder()
                                //  .id(demotEntity.getId())
                                .topText(demotEntity.getTopText())
                                .bottomText(demotEntity.getBottomText())
                                .imagePath(demotEntity.getImagePath())
                                .build())
                        .collect(Collectors.toList())).build();
    }

    public void deleteDemot(Long id) {
        demotRepo.deleteById(id);
    }

    public void update(Long id, DemotEntity demotToUpdate) {
        DemotEntity demotEntity = demotRepo.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego ID"));

        demotEntity.setTopText(demotToUpdate.getTopText());
        demotEntity.setImagePath(demotToUpdate.getImagePath());
        demotEntity.setBottomText(demotToUpdate.getBottomText());
    }

    public VoteCounter showReactions(Long demotId) {
        List<String> votes = demotRepo.findById(demotId).get().getVoteId()
                .stream().map(entity -> entity.getVote().toString()).collect(Collectors.toList());

        int plus = 0;
        int minus = 0;
        for (String vote : votes) {
            if (vote.equals(VoteEntity.VOTE_TYPE.VOTE_UP.toString())) {
                plus += 1;
            } else {
                minus += 1;
            }
        }
        return new VoteCounter(plus, minus);
    }

}
//  /api/posts/{postId}/reactions/voteUp  /api/posts/{postId}/reactions/voteDown



