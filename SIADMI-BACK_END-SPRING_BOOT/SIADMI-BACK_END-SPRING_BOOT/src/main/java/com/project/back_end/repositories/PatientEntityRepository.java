package com.project.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.back_end.entities.PatientEntity;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {

}
