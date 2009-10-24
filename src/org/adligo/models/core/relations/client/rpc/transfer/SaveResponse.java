package org.adligo.models.core.relations.client.rpc.transfer;

import java.io.Serializable;

public class SaveResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean successful;

	
	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
}
