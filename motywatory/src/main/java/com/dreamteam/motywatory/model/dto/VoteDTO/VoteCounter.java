package com.dreamteam.motywatory.model.dto.VoteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteCounter {

    private int votesUp;
    private int votesDown;
}
