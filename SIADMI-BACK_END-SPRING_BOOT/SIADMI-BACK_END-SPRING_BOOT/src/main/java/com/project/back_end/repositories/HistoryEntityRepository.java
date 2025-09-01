package com.project.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back_end.entities.HistoryEntity;

@Repository
public interface HistoryEntityRepository extends JpaRepository<HistoryEntity, Long> {

}
