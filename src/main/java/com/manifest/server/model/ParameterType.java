package com.manifest.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParameterType {
	
	@Id 
	@GeneratedValue 
	private Long id;
	
	private String libraryName;
	
//	@ManyToMany(mappedBy = "parameterTypes")
//	@JsonProperty(access = Access.WRITE_ONLY)
//	private List<CodingChallenge> codingChallenges;

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
//    public List<CodingChallenge> getCodingChallenges() {
//        return codingChallenges;
//    }
//    
//    public void setCodingChallenges(List<CodingChallenge> codingChallenges) {
//        this.codingChallenges = codingChallenges;
//    }
}
