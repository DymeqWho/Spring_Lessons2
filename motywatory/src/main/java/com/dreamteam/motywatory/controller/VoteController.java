package com.dreamteam.motywatory.controller;

import com.dreamteam.motywatory.model.dto.VoteDTO.CreateVoteRequest;
import com.dreamteam.motywatory.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping(path = "/api/posts/{postId}/reactions")
    public void createVote(@RequestBody CreateVoteRequest request,@PathVariable(name = "postId") Long postId) {
        voteService.createVoteRequest(request, postId);
    }

    @Transactional
    @PutMapping(path = "/api/posts/{postId}/reactions/{vote}")
    public void addDemotReactionUp(@PathVariable(name = "postId") Long postId, @PathVariable (name = "vote") String vote) {
       // voteService.vote(postId, vote);
    }
}
