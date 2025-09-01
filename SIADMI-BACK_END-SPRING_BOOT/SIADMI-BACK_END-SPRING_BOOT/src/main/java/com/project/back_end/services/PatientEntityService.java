package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.dto.PatientEntityDTO;
import com.project.back_end.entities.HistoryEntity;
import com.project.back_end.entities.PatientEntity;
import com.project.back_end.repositories.PatientEntityRepository;
import com.project.back_end.services.exceptions.DatabaseException;
import com.project.back_end.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientEntityService {
	
	@Autowired
    private PatientEntityRepository repository;

    @Transactional(readOnly = true)
    public PatientEntityDTO findById(Long id) {
        PatientEntity PatientEntity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new PatientEntityDTO(PatientEntity);
    }

    @Transactional(readOnly = true)
    public Page<PatientEntityDTO> findAll(Pageable pageable) {
        Page<PatientEntity> result = repository.findAll(pageable);
        return result.map(x -> new PatientEntityDTO(x));
    }

    @Transactional
    public PatientEntityDTO insert(PatientEntityDTO dto) {
        PatientEntity entity = new PatientEntity();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PatientEntityDTO(entity);
    }

    @Transactional
    public PatientEntityDTO update(Long id, PatientEntityDTO dto) {
        try {
            PatientEntity entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PatientEntityDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
    	if (!repository.existsById(id)) {
    		throw new ResourceNotFoundException("Recurso não encontrado");
    	}
    	try {
            repository.deleteById(id);    		
    	}
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(PatientEntityDTO dto, PatientEntity entity) {
    	entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        
        entity.getHistory().clear();
        for (HistoryEntityDTO histDto : dto.getHistory()) {
        	HistoryEntity hist = new HistoryEntity();
        	hist.setId(histDto.getId());
        	entity.getHistory().add(hist);
        }
    }
}
