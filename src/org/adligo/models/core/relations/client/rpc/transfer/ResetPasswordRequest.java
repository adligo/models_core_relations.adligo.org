package org.adligo.models.core.relations.client.rpc.transfer;

import java.io.Serializable;

public class ResetPasswordRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -537566828909616088L;
	private String password;
	private String emailToken;
	
	public String getPassword() {
		return password;
	}
	public String getEmailToken() {
		return emailToken;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}
	
}
