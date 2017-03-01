package com.manifest.server.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Solution {
	
	@Id
	@GeneratedValue
	private Long id;
	private String sourceCode;
	private Boolean passesTests;
	private long executionTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coding_challenge_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private CodingChallenge codingChallenge;	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSourceCode() {
		return sourceCode;
	}
	
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	public Boolean getPassesTests() {
		return passesTests;
	}
	
	public void setPassesTests(Boolean passesTests) {
		this.passesTests = passesTests;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public CodingChallenge getCodingChallenge() {
		return codingChallenge;
	}

	public void setCodingChallenge(CodingChallenge codingChallenge) {
		this.codingChallenge = codingChallenge;
	}

}
