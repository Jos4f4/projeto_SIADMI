package com.project.back_end.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.services.HistoryEntityService;

@RestController
@RequestMapping(value = "/history_entity_controller")
public class HistoryEntityController {
	
	@Autowired
	private HistoryEntityService historyEntityService;
	
	@PostMapping(value = "/history", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public HistoryEntityDTO createHistory(
	        @RequestPart("dto") HistoryEntityDTO dto,
	        @RequestPart("file") MultipartFile file) {

	    return historyEntityService.insertWithAi(dto, file);
	}
}
