package com.project.back_end.dto;

import java.io.Serializable;

public class DiagnosisResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String prediction;
	private double confidence;

	public DiagnosisResponseDTO() {
		
	}

	public DiagnosisResponseDTO(String prediction, double confidence) {
	    this.prediction = prediction;
	    this.confidence = confidence;
	}

	public String getPrediction() {
	    return prediction;
	}

	public void setPrediction(String prediction) {
	    this.prediction = prediction;
	}

	public double getConfidence() {
	    return confidence;
	}

	public void setConfidence(double confidence) {
	    this.confidence = confidence;
	}
}
