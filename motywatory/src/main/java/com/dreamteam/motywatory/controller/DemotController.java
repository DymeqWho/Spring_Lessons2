package com.dreamteam.motywatory.controller;

import com.dreamteam.motywatory.model.dao.DemotEntity;
import com.dreamteam.motywatory.model.dto.DemotDTO.CreateDemotRequest;
import com.dreamteam.motywatory.model.dto.DemotDTO.GetAllDemotResponse;
import com.dreamteam.motywatory.model.dto.DemotDTO.ReadDemotResponse;
import com.dreamteam.motywatory.model.dto.VoteDTO.VoteCounter;
import com.dreamteam.motywatory.service.DemotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DemotController {

    private final DemotService demotService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/posts")
    public void createDemot(@RequestBody CreateDemotRequest request) {
        demotService.createDemotRequest(request);
    }

    @GetMapping("/api/posts/{postId}")
    public ReadDemotResponse getReadDemot(@PathVariable(name = "postId") Long postId) {
        return demotService.readDemotResponse(postId);
    }

    @GetMapping(path = "/api/posts")
    public GetAllDemotResponse getAllDemots() {
        return demotService.getAllDemots();
    }

    @Transactional
    @PutMapping(path = "/api/posts/{postId}")
    public void updateDemot(@PathVariable(name = "postId") Long id, @RequestBody DemotEntity demotToUpdate) {
        demotService.update(id, demotToUpdate);
    }

    @DeleteMapping("/api/posts/{postId}")
    public void deleteDemot(@PathVariable(name = "postId") Long postId) {
        demotService.deleteDemot(postId);
    }

    @GetMapping("/api/posts/{postId}/reactions")
    public VoteCounter showReactions(@PathVariable(name = "postId") Long postId) {
        return demotService.showReactions(postId);
    }

}
