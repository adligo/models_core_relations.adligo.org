package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;

public class UserSaveResponse implements I_Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean successful;
	protected SaveUserFailureReasons failureCause;
	protected String eventSource;
	
	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public SaveUserFailureReasons getFailureCause() {
		return failureCause;
	}

	public void setFailureCause(SaveUserFailureReasons failureCause) {
		this.failureCause = failureCause;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(SaveResponse.class));
		sb.append(" [successful=");
		sb.append(successful);
		sb.append(",failureCause=");
		sb.append(failureCause);
		sb.append(",eventSource=");
		sb.append(eventSource);
		sb.append("]");
		return sb.toString();
	}
}
