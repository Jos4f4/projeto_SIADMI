package com.project.back_end.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.services.HistoryEntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/history_entity_controller")
public class HistoryEntityController {
	
	@Autowired
	private HistoryEntityService service;
	
	@PostMapping
	public ResponseEntity<HistoryEntityDTO> insert(@Valid @RequestBody HistoryEntityDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
