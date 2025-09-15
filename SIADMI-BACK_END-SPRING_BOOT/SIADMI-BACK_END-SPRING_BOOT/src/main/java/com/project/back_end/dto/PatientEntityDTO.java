package com.project.back_end.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.project.back_end.entities.HistoryEntity;
import com.project.back_end.entities.PatientEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientEntityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
	private String name;
	
	@Size(min = 1, max = 11, message = "Nome precisar ter de 1 a 11 caracteres")
	@NotBlank(message = "Campo requerido")
	private String cpf;
	
	private List<HistoryEntityDTO> history = new ArrayList<>();
	
	public PatientEntityDTO() {
		
	}
	
	public PatientEntityDTO(Long id, String name, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}
	
	public PatientEntityDTO(PatientEntity entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();	
		
		for (HistoryEntity hist : entity.getHistory()) {
        	history.add(new HistoryEntityDTO(hist));
        }
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<HistoryEntityDTO> getHistory(){
		return history;
	}
	
}
