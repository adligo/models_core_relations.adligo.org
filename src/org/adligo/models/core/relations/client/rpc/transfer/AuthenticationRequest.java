package org.adligo.models.core.relations.client.rpc.transfer;

import java.io.Serializable;

/**
 * basic authentication request, 
 * you can extend to add different types of paramters
 * 
 * @author scott
 *
 */
public class AuthenticationRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String domain;
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
