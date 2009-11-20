package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.EMail;
import org.adligo.models.core.relations.client.rpc.transfer.EmailAssistanceReponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserNameAssistanceServiceAsync {
	/**
	 * 
	 * @param email
	 * @param callback the callback to return if successfully sent email,
	 *  	or the reason why not in English
	 */
	public void requestUserNameEmail(EMail email, AsyncCallback<EmailAssistanceReponse> callback);
}
