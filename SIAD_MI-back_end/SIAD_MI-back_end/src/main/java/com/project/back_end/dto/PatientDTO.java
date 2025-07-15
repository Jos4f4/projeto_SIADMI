package com.project.back_end.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.project.back_end.entities.PatientEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private Long id;
	
	@NotBlank(message = "Required field")
	@Size(min = 5, max= 60, message = "There must be between 5 and 60 characters")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "Required field")
	private LocalDate dateOfBirth;
	
	@NotBlank(message = "Required field")
	@Size(min = 1, max= 11, message = "11 Digits")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "Required field")
	@Size(min = 1, max= 9, message = "9 Digits")
	@Column(unique = true)
	private String rg;
	
	@NotBlank(message = "Required field")
	@Size(min = 5, max= 60, message = "There must be between 5 and 60 characters")
	private String sex;
	
	@NotBlank(message = "Required field")
	@Size(min = 5, max= 60, message = "There must be between 5 and 60 characters")
	private String 	nationality;
	
	@NotBlank(message = "Required field")
	@Size(min = 5, max= 60, message = "There must be between 5 and 60 characters")
	private String naturalness;
	
	@NotBlank(message = "Required field")
	@Size(min = 5, max= 60, message = "There must be between 5 and 100 characters")
	private String adress;
	
	// Format number phone +5592999999999
	@NotBlank(message = "Required fieldo")
	@Size(min = 1, max= 60, message = "14 Digits")
	@Column(unique = true)
	private String phoneNumber;
	
	@Email(message = "Insert valid email")
	@Column(unique = true)
	private String email;
	
	public PatientDTO () {
		
	}

	public PatientDTO(Long id, String name, LocalDate dateOfBirth, String cpf, String rg, String sex,
			String nationality, String naturalness, String adress, String phoneNumber, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.rg = rg;
		this.sex = sex;
		this.nationality = nationality;
		this.naturalness = naturalness;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public PatientDTO (PatientEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.dateOfBirth = entity.getDateOfBirth();
		this.cpf = entity.getCpf();
		this.rg = entity.getRg();
		this.sex = entity.getSex();
		this.nationality = entity.getNationality();
		this.naturalness = entity.getNaturalness();
		this.adress = entity.getAdress();
		this.phoneNumber = entity.getPhoneNumber();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNaturalness() {
		return naturalness;
	}

	public void setNaturalness(String naturalness) {
		this.naturalness = naturalness;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
