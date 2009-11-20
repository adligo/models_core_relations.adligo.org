package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.rpc.transfer.EmailAssistanceReponse;
import org.adligo.models.core.relations.client.rpc.transfer.EmailAssistanceRequest;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/UserNameAssistanceService")
public interface UserNameAssistanceService extends RemoteService {
	/**
	 * 
	 * @param email
	 * @return if successfully sent email,
	 *  	or the reason why not in English
	 */
	public EmailAssistanceReponse requestUserNameEmail(EmailAssistanceRequest email);
}
