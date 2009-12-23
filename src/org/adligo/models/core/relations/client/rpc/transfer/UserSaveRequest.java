package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.relations.client.UserRelations;

public class UserSaveRequest implements I_Serializable {
	private static final long serialVersionUID = 1L;
	protected UserRelations saveObj;
	protected String eventSource;
	
	/**
	 * for gwt serialization
	 */
	public UserSaveRequest() {
	}
	
	public UserSaveRequest(UserRelations p_saveObj, String p_eventSource) {
		saveObj = p_saveObj;
		eventSource = p_eventSource;
	}
	
	public UserRelations getSaveObj() {
		return saveObj;
	}

	public void setSaveObj(UserRelations saveObj) {
		this.saveObj = saveObj;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(SaveRequest.class));
		sb.append(" [saveObj=");
		sb.append(saveObj);
		sb.append(",eventSource=");
		sb.append(eventSource);
		sb.append("]");
		
		return sb.toString();
	}
}
