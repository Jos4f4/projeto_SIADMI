package com.project.back_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.back_end.entities.DiagnosisResponseEntity;
import com.project.back_end.services.DiagnosisService;

@RestController
@RequestMapping("api/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }
    
    @PostMapping("/analyze")
    public ResponseEntity<DiagnosisResponseEntity> analyze(@RequestParam("file") MultipartFile file) {
        DiagnosisResponseEntity response = diagnosisService.processImage(file);
        return ResponseEntity.ok(response);
    }
}
