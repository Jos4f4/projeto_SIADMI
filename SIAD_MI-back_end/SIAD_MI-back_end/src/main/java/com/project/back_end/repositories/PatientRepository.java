package com.project.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back_end.entities.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
