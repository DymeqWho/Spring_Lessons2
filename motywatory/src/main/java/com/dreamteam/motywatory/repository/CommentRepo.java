package com.dreamteam.motywatory.repository;

import com.dreamteam.motywatory.model.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentEntity, Long> {
}
