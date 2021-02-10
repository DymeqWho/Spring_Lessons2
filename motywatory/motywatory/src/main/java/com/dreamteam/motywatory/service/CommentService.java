package com.dreamteam.motywatory.service;

import com.dreamteam.motywatory.model.dao.CommentEntity;
import com.dreamteam.motywatory.model.dao.DemotEntity;
import com.dreamteam.motywatory.model.dto.ComentDTO.CreateCommentRequest;
import com.dreamteam.motywatory.model.dto.ComentDTO.ReadCommentResponse;
import com.dreamteam.motywatory.repository.CommentRepo;
import com.dreamteam.motywatory.repository.DemotRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;
    private final DemotRepo demotRepo;

    @Transactional
    public void createCommentRequest(CreateCommentRequest createCommentRequest, Long demotId) {
        CommentEntity commentEntity = new CommentEntity();

        DemotEntity demotEntity = demotRepo.findById(demotId).orElseThrow(() -> new RuntimeException("nie mamy pana Demota i co nam Pan zrobi?"));
        commentEntity.setContent(createCommentRequest.getContent());
        commentEntity.setDemotId(demotEntity);
        commentEntity = commentRepo.save(commentEntity);
        demotEntity.getComments().add(commentEntity);

    }

    public ReadCommentResponse readCommentResponse(Long commentId) {
        return new ReadCommentResponse(commentRepo.findById(commentId).orElseThrow(() -> new RuntimeException( "pusto tu! Wieje sandałem!")).getContent());
    }

    public void update(Long id, CommentEntity commentToUpdate) {
        CommentEntity commentEntity = commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego ID"));

        commentEntity.setContent(commentToUpdate.getContent());

    }

    public void delete(Long id) {
        CommentEntity commentEntity = commentRepo.findById(id).orElseThrow();
        commentEntity.getDemotId().getComments().remove(commentEntity);
        commentRepo.delete(commentEntity);
    }


}
