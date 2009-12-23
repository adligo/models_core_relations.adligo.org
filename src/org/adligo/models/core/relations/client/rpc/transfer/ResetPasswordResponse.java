package org.adligo.models.core.relations.client.rpc.transfer;

import java.io.Serializable;

import org.adligo.models.core.client.I_User;

public class ResetPasswordResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SaveResponse saveResponse;
	private I_User user;
	
	public SaveResponse getSaveResponse() {
		return saveResponse;
	}
	public I_User getUser() {
		return user;
	}
	public void setSaveResponse(SaveResponse saveResponse) {
		this.saveResponse = saveResponse;
	}
	public void setUser(I_User user) {
		this.user = user;
	}
	
}
