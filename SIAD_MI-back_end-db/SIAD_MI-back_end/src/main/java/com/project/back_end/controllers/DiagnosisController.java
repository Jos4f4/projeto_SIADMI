package com.project.back_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.back_end.dto.DiagnosisResponseDTO;
import com.project.back_end.services.DiagnosisServiceImpl;

@RestController
@RequestMapping("api/diagnosis")
public class DiagnosisController {

    private final DiagnosisServiceImpl diagnosisService;

    public DiagnosisController(DiagnosisServiceImpl diagnosisService) {
        this.diagnosisService = diagnosisService;
    }
    
    @CrossOrigin(origins = "*") //TEMPORABLE
    @PostMapping("/analyze")
    public ResponseEntity<DiagnosisResponseDTO> analyze(@RequestParam("file") MultipartFile file) {
        DiagnosisResponseDTO response = diagnosisService.analyzeImage(file);
        return ResponseEntity.ok(response);
    }
}
