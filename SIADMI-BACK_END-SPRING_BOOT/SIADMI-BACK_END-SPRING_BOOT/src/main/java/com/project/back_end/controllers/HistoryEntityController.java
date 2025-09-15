package com.project.back_end.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.back_end.dto.HistoryEntityDTO;
import com.project.back_end.services.HistoryEntityService;

/*
@RestController
@RequestMapping(value = "/api-diagnosis")
public class HistoryEntityController {
	
	@Autowired
	private HistoryEntityService historyEntityService;
	
	@PostMapping(value = "/diagnosis", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public HistoryEntityDTO createHistory(
	        @RequestPart("dto") HistoryEntityDTO dto,
	        @RequestPart("file") MultipartFile file) throws Exception {
		
	    return historyEntityService.insertWithAi(dto, file);
	}
}*/

@RestController
@RequestMapping(value = "/api-diagnosis")
public class HistoryEntityController {

    @Autowired
    private HistoryEntityService historyEntityService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/diagnosis", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public HistoryEntityDTO createHistory(
            @RequestPart("dto") String dtoJson,
            @RequestPart("file") MultipartFile file) throws Exception {

        // Converte o JSON (string) em DTO
        HistoryEntityDTO dto = objectMapper.readValue(dtoJson, HistoryEntityDTO.class);

        return historyEntityService.insertWithAi(dto, file);
    }
}
