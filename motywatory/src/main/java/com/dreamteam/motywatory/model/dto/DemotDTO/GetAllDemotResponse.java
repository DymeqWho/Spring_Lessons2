package com.dreamteam.motywatory.model.dto.DemotDTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
public class GetAllDemotResponse {
    private final List<ReadDemotResponse> demots;
}
