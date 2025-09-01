package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.back_end.entities.DiagnosisResponseEntity;

@Service
public class DiagnosisService {
	
	@Autowired
	private WebClient webClient;

	public DiagnosisResponseEntity processImage(MultipartFile file) {
	    try {
	        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
	            @Override
	            public String getFilename() {
	                return file.getOriginalFilename();
	            }
	        };

	        LinkedMultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
	        formData.add("file", resource);

	        String responseString = webClient.post()
	                .uri("/predict")
	                .contentType(MediaType.MULTIPART_FORM_DATA)
	                .bodyValue(formData)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();

	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode json = mapper.readTree(responseString);

	        return new DiagnosisResponseEntity(
	                json.get("prediction").asText(),
	                json.get("confidence").asDouble()
	        );

	    } catch (Exception e) {
	        return new DiagnosisResponseEntity("erro", 0.0);
	    }
	}
}
