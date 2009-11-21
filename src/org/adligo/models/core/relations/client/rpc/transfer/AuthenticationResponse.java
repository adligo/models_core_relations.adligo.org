package org.adligo.models.core.relations.client.rpc.transfer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.relations.client.UserRelations;

public class AuthenticationResponse implements I_Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * if null the authentication was not sucessfull!
	 */
	protected UserRelations user;
	protected Map<String, Serializable> newConfig = new HashMap<String, Serializable>();
	
	public UserRelations getUser() {
		return user;
	}
	public void setUser(UserRelations user) {
		this.user = user;
	}
	public Map<String, Serializable> getNewConfig() {
		return newConfig;
	}
	public void setNewConfig(Map<String, Serializable> newConfig) {
		this.newConfig = newConfig;
	}

	

}
