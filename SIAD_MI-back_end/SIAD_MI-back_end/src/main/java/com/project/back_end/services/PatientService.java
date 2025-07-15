package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.back_end.dto.PatientDTO;
import com.project.back_end.entities.PatientEntity;
import com.project.back_end.repositories.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Transactional(readOnly = true)
	public Page<PatientDTO> findAllPaged(Pageable pageable){
		Page<PatientEntity> list = patientRepository.findAll(pageable);
		return list.map(x -> new PatientDTO(x));
	}
	
	/*
	@Transactional(readOnly = true)
	public PatientDTO findById(Long id) {
		Optional<PatientEntity> obj = patientRepository.findById(id);
		PatientEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PatientDTO(entity);
	}
	*/
	
	@Transactional
	public PatientDTO insert(PatientDTO dto) {
		PatientEntity entity = new PatientEntity();
		copyDtoToEntity(dto, entity);
		entity = patientRepository.save(entity);
		return new PatientDTO(entity);
	}
	
	private void copyDtoToEntity(PatientDTO dto, PatientEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setCpf(dto.getCpf());
		entity.setRg(dto.getRg());
		entity.setSex(dto.getSex());
		entity.setNationality(dto.getNationality());
		entity.setNaturalness(dto.getNaturalness());
		entity.setAdress(dto.getAdress());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setEmail(dto.getEmail());
	}
}
