package com.authentication.models;

public class ValidInvalidUserResponse {
	
	private boolean authenticated;
    private String massage;

	public ValidInvalidUserResponse(String massage ,boolean authenticated) {
		super();
		this.authenticated = authenticated;
		this.massage = massage;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	
	
}
