package com.dreamteam.motywatory.model.dto.DemotDTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDemotRequest {

    private String topText;

    private String imagePath;

    private String bottomText;

}
