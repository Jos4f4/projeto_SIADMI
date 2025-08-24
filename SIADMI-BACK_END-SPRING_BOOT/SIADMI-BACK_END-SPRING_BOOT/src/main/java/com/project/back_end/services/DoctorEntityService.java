package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.back_end.dto.DoctorEntityDTO;
import com.project.back_end.entities.DoctorEntity;
import com.project.back_end.repositories.DoctorEntityRepository;
import com.project.back_end.services.exceptions.DatabaseException;
import com.project.back_end.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DoctorEntityService {
	
	@Autowired
    private DoctorEntityRepository repository;

    @Transactional(readOnly = true)
    public DoctorEntityDTO findById(Long id) {
        DoctorEntity DoctorEntity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new DoctorEntityDTO(DoctorEntity);
    }

    @Transactional(readOnly = true)
    public Page<DoctorEntityDTO> findAll(Pageable pageable) {
        Page<DoctorEntity> result = repository.findAll(pageable);
        return result.map(x -> new DoctorEntityDTO(x));
    }

    @Transactional
    public DoctorEntityDTO insert(DoctorEntityDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DoctorEntityDTO(entity);
    }

    @Transactional
    public DoctorEntityDTO update(Long id, DoctorEntityDTO dto) {
        try {
            DoctorEntity entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new DoctorEntityDTO(entity);
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

    private void copyDtoToEntity(DoctorEntityDTO dto, DoctorEntity entity) {
    	entity.setCrm(dto.getCrm());
        entity.setName(dto.getName());
    }
}
