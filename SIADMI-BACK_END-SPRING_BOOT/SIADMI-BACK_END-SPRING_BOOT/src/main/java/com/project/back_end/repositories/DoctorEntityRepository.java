package com.project.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.back_end.entities.DoctorEntity;

public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {

}
