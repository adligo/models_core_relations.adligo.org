package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.client.EMail;

public class EmailAssistanceRequest implements I_Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected EMail email;
	/**
	 * this is the client locale (en,fr)
	 * so that the email can go out in the correct language
	 */
	protected String clientLocale;
	
	public String getClientLocale() {
		return clientLocale;
	}
	public void setClientLocale(String clientLocale) {
		this.clientLocale = clientLocale;
	}
	public EMail getEmail() {
		return email;
	}
	public void setEmail(EMail email) {
		this.email = email;
	}
	
}
