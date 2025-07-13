package com.project.back_end.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.back_end.dto.DiagnosisResponseDTO;

@Service	
public class DiagnosisServiceImpl {
	
	@Value("${python.ia.url}")
	private String pythonIaUrl;

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	public DiagnosisServiceImpl() {
	    this.restTemplate = new RestTemplate();
	    this.objectMapper = new ObjectMapper();
	}

	public DiagnosisResponseDTO analyzeImage(MultipartFile image) {
	    try {
	        ByteArrayResource imageResource = new ByteArrayResource(image.getBytes()) {
	            @Override
	            public String getFilename() {
	                return image.getOriginalFilename();
	            }
	        };

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

	        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	        body.add("file", imageResource);

	        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity(pythonIaUrl, requestEntity, String.class);

	        if (response.getStatusCode() == HttpStatus.OK) {
	            JsonNode json = objectMapper.readTree(response.getBody());
	            String prediction = json.get("prediction").asText();
	            double confidence = json.get("confidence").asDouble();

	            return new DiagnosisResponseDTO(prediction, confidence);
	        } else {
	            throw new RuntimeException("Erro ao comunicar com o serviço de IA");
	        }

	    } catch (IOException e) {
	        throw new RuntimeException("Erro ao processar a imagem", e);
	    }
	}
}
