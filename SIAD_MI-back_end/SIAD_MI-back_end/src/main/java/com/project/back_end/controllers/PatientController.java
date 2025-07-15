package com.project.back_end.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.back_end.dto.PatientDTO;
import com.project.back_end.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<Page<PatientDTO>> findAll(Pageable pageable){
		Page<PatientDTO> list = patientService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<PatientDTO> findById(@PathVariable Long id){
		PatientDTO dto = patientService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	*/
	
	@PostMapping
	public ResponseEntity<PatientDTO> insert(@Valid @RequestBody PatientDTO dto){
		dto = patientService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
}
