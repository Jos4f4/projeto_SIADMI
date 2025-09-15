package com.project.back_end.entities;

import java.io.Serializable;

public class DiagnosisResponseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String prediction;
	private double confidence;
	
	public DiagnosisResponseEntity() {
		
	}

	public DiagnosisResponseEntity(String prediction, double confidence) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(confidence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prediction == null) ? 0 : prediction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiagnosisResponseEntity other = (DiagnosisResponseEntity) obj;
		if (Double.doubleToLongBits(confidence) != Double.doubleToLongBits(other.confidence))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prediction == null) {
			if (other.prediction != null)
				return false;
		} else if (!prediction.equals(other.prediction))
			return false;
		return true;
	}
}
