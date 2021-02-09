package com.dreamteam.motywatory.model.dto.VoteDTO;

import com.dreamteam.motywatory.model.dao.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadVoteResponse {
    private VoteEntity.VOTE_TYPE vote;
}
