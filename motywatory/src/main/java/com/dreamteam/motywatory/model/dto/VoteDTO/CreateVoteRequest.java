package com.dreamteam.motywatory.model.dto.VoteDTO;

import com.dreamteam.motywatory.model.dao.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVoteRequest {

    private VoteEntity.VOTE_TYPE vote;

    private Long demotId;


}
