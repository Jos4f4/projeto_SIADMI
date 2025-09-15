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
    
	private PatientEntity patient;
	private DoctorEntity doctor;
	private String aiDiagnosis;
	private Double aiConfidence;
	
	@NotBlank(message = "Campo requerido")
	private String description;

	public HistoryEntityDTO() {
		
	}
	
	public HistoryEntityDTO(Long id, LocalDate localDate, PatientEntity patient, DoctorEntity doctor, 
			String aiDiagnosis, Double aiConfidence, String description) {
		super();
		this.id = id;
		this.localDate = localDate;
		this.patient = patient;
		this.doctor = doctor;
		this.aiDiagnosis = aiDiagnosis;
		this.aiConfidence = aiConfidence;
		this.description = description;
	}
	
	public HistoryEntityDTO(HistoryEntity entity) {
		super();
		this.id = entity.getId();
		this.localDate = entity.getLocalDate();
		this.patient = entity.getPatient();
		this.doctor = entity.getDoctor();
		this.aiDiagnosis = entity.getAiDiagnosis();
		this.aiConfidence = entity.getAiConfidence();
		this.description = entity.getDescription();
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

	public String getAiDiagnosis() {
		return aiDiagnosis;
	}

	public void setAiDiagnosis(String aiDiagnosis) {
		this.aiDiagnosis = aiDiagnosis;
	}

	public Double getAiConfidence() {
		return aiConfidence;
	}

	public void setAiConfidence(Double aiConfidence) {
		this.aiConfidence = aiConfidence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
