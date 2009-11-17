package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.I_Serializable;

public class ResetPasswordRequest implements I_Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
