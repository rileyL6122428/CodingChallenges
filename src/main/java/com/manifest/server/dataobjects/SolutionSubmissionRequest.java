package com.manifest.server.dataobjects;

public class SolutionSubmissionRequest {
	private String sourceCode;
	private long challengeId;

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public long getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(long challengeId) {
		this.challengeId = challengeId;
	}
}
