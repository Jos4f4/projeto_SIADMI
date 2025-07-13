package com.project.back_end.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private String cpf;
	private String rg;
	private String sex;
	private String 	nationality;
	private String naturalness;
	private String adress;
	private String phoneNumber;
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
