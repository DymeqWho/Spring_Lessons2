package com.dreamteam.motywatory.repository;

import com.dreamteam.motywatory.model.dao.DemotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemotRepo extends JpaRepository<DemotEntity, Long> {



}
