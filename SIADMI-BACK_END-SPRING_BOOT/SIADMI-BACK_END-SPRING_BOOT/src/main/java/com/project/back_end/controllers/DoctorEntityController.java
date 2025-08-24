package com.project.back_end.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.back_end.dto.DoctorEntityDTO;
import com.project.back_end.services.DoctorEntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/doctor_entity_controller")
public class DoctorEntityController {

    @Autowired
    private DoctorEntityService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorEntityDTO> findById(@PathVariable Long id) {
        DoctorEntityDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorEntityDTO>> findAll(Pageable pageable) {
        Page<DoctorEntityDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DoctorEntityDTO> insert(@Valid @RequestBody DoctorEntityDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getCrm()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DoctorEntityDTO> update(@PathVariable Long id, @Valid @RequestBody DoctorEntityDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
