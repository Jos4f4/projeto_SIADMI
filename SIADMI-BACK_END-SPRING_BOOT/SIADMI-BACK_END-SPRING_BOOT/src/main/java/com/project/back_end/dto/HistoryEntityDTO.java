package com.project.back_end.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.project.back_end.entities.DoctorEntity;
import com.project.back_end.entities.HistoryEntity;
import com.project.back_end.entities.PatientEntity;

import jakarta.validation.constraints.NotBlank;

public class HistoryEntityDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate localDate;
	
    @NotBlank(message = "Campo requerido")
	private String description;
    
	private PatientEntity patient;
	private DoctorEntity doctor;

	public HistoryEntityDTO(Long id, LocalDate localDate, String description, PatientEntity patient, DoctorEntity doctor) {
		super();
		this.id = id;
		this.localDate = localDate;
		this.description = description;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	public HistoryEntityDTO(HistoryEntity entity) {
		super();
		this.id = entity.getId();
		this.localDate = entity.getLocalDate();
		this.description = entity.getDescription();
		this.patient = entity.getPatient();
		this.doctor = entity.getDoctor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
}
