package com.dreamteam.motywatory.controller;

import com.dreamteam.motywatory.model.dao.CommentEntity;
import com.dreamteam.motywatory.model.dto.ComentDTO.CreateCommentRequest;
import com.dreamteam.motywatory.model.dto.ComentDTO.ReadCommentResponse;
import com.dreamteam.motywatory.model.dto.VoteDTO.CreateVoteRequest;
import com.dreamteam.motywatory.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/api/posts/{postId}/comments")
    public void createComment(@RequestBody CreateCommentRequest request, @PathVariable(name = "postId") Long postId) {
        commentService.createCommentRequest(request, postId);
    }

    @GetMapping(path = "/api/posts/comments/{commentId}")
    public ReadCommentResponse getComment(@PathVariable(name = "commentId") Long commentId) {
        return commentService.readCommentResponse(commentId);
    }

    @Transactional
    @PutMapping(path = "/api/posts/comments/{commentId}")
    public void changeComment(@RequestBody CommentEntity request, @PathVariable(name = "commentId") Long commentId) {
        commentService.update(commentId, request);
    }

    @Transactional
    @DeleteMapping(path = "/api/posts/comments/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId){
        commentService.delete(commentId);

    }
}
