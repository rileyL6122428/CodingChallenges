package com.manifest.server.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CodingChallenge {

	@Id 
	@GeneratedValue 
	private Long id;
	
	@Column(columnDefinition = "text")
	private String description;
	
	private String name; 
	private String difficulty;
	private String methodSignature;
	private String imageUrl;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="coding_challenge_parameter_types_join", joinColumns = @JoinColumn(name = "challenge_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "parameter_type_id", referencedColumnName = "id"))
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<ParameterType> parameterTypes;
	
	@OneToMany(mappedBy = "codingChallenge", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Solution> solutions;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="coding_challenge_hints_join", joinColumns = @JoinColumn(name = "challenge_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "hint_id", referencedColumnName = "id"))
	private List<ChallengeHint> hints;
	
	@CreatedDate
	private Date dateCreated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}
		
	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public List<ParameterType> getParameterTypes() {
		return parameterTypes;
	}

	public void setParameterTypes(List<ParameterType> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
