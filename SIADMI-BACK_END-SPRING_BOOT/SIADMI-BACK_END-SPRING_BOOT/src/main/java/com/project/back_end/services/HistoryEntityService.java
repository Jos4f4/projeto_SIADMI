package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.entities.HistoryEntity;
import com.project.back_end.repositories.HistoryEntityRepository;

@Service
public class HistoryEntityService {
	
	@Autowired
	private HistoryEntityRepository repository;

	@Transactional
	public HistoryEntityDTO insert(HistoryEntityDTO dto) {
		HistoryEntity entity = new HistoryEntity();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new HistoryEntityDTO(entity);
	}

	private void copyDtoToEntity(HistoryEntityDTO dto, HistoryEntity entity) {
		entity.setId(dto.getId());
		entity.setLocalDate(dto.getLocalDate());
		entity.setDescription(dto.getDescription());
		entity.setPatient(dto.getPatient());
		entity.setDoctor(dto.getDoctor());
	}
}
