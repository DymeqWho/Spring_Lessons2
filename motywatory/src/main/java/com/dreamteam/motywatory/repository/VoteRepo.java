package com.dreamteam.motywatory.repository;

import com.dreamteam.motywatory.model.dao.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<VoteEntity, Long> {
}
