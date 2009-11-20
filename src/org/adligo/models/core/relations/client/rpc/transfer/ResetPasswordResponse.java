package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.client.User;

public class ResetPasswordResponse implements I_Serializable {
	private static final long serialVersionUID = 1L;
	
	private SaveResponse<ResetPasswordFailureReasons> saveResponse;
	private User user;
	
	public SaveResponse<ResetPasswordFailureReasons> getSaveResponse() {
		return saveResponse;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setSaveResponse(SaveResponse<ResetPasswordFailureReasons> saveResponse) {
		this.saveResponse = saveResponse;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
