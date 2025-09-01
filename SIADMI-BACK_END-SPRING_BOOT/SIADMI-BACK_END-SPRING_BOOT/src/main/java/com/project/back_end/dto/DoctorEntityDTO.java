package com.project.back_end.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.project.back_end.entities.DoctorEntity;
import com.project.back_end.entities.HistoryEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DoctorEntityDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long crm;
	
	@Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
	private String name;
	
    private List<HistoryEntityDTO> history = new ArrayList<>();
    
	public DoctorEntityDTO(Long crm, String name) {
		super();
		this.crm = crm;
		this.name = name;
	}
	
	public DoctorEntityDTO(DoctorEntity entity) {
		super();
		crm = entity.getCrm();
		name = entity.getName();
		
		for (HistoryEntity hist : entity.getHistory()) {
        	history.add(new HistoryEntityDTO(hist));
        }
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HistoryEntityDTO> getHistory() {
		return history;
	}
}
