package com.dreamteam.motywatory.model.dto.DemotDTO;

import com.dreamteam.motywatory.model.dao.VoteEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadDemotResponse {

    private String topText;

    private String imagePath;

    private String bottomText;

    private List<String> vote;

}
