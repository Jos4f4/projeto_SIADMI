package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.entities.DiagnosisResponseEntity;
import com.project.back_end.entities.HistoryEntity;
import com.project.back_end.repositories.HistoryEntityRepository;

@Service
public class HistoryEntityService {
	
	@Autowired
	private HistoryEntityRepository repository;
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@Transactional
	public HistoryEntityDTO insertWithAi(HistoryEntityDTO dto, MultipartFile file) {
	    // Call for AI Service
	    DiagnosisResponseEntity aiResponse = diagnosisService.processImage(file);

	    // Insert the data of IA in the DTO
	    dto.setAiDiagnosis(aiResponse.getPrediction());
	    dto.setAiConfidence(aiResponse.getConfidence());

	    // Save normally
	    HistoryEntity entity = new HistoryEntity();
	    copyDtoToEntity(dto, entity);
	    entity = repository.save(entity);

	    return new HistoryEntityDTO(entity);
	}

	private void copyDtoToEntity(HistoryEntityDTO dto, HistoryEntity entity) {
	    entity.setId(dto.getId());
	    entity.setLocalDate(dto.getLocalDate());
	    entity.setPatient(dto.getPatient());
	    entity.setDoctor(dto.getDoctor());
	    entity.setAiDiagnosis(dto.getAiDiagnosis());
	    entity.setAiConfidence(dto.getAiConfidence());
	    entity.setDescription(dto.getDescription());   
	}
}
