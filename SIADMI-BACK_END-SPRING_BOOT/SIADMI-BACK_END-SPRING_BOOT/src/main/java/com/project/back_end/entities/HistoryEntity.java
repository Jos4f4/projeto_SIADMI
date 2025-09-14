package com.project.back_end.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_history_entity")
public class HistoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate localDate;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;
	
	private String aiDiagnosis;
	private Double aiConfidence;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	public HistoryEntity() {
		
	}

	public HistoryEntity(Long id, LocalDate localDate, PatientEntity patient, DoctorEntity doctor,
			String aiDiagnosis, Double aiConfidenci, String description) {
		super();
		this.id = id;
		this.localDate = localDate;
		this.patient = patient;
		this.doctor = doctor;
		this.aiDiagnosis = aiDiagnosis;
		this.aiConfidence = aiConfidenci;
		this.description = description;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aiConfidence == null) ? 0 : aiConfidence.hashCode());
		result = prime * result + ((aiDiagnosis == null) ? 0 : aiDiagnosis.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localDate == null) ? 0 : localDate.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryEntity other = (HistoryEntity) obj;
		if (aiConfidence == null) {
			if (other.aiConfidence != null)
				return false;
		} else if (!aiConfidence.equals(other.aiConfidence))
			return false;
		if (aiDiagnosis == null) {
			if (other.aiDiagnosis != null)
				return false;
		} else if (!aiDiagnosis.equals(other.aiDiagnosis))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localDate == null) {
			if (other.localDate != null)
				return false;
		} else if (!localDate.equals(other.localDate))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}
}
