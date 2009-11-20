package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.EMail;
import org.adligo.models.core.relations.client.rpc.transfer.EmailAssistanceReponse;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/UserInfoService")
public interface UserNameAssistanceService extends RemoteService {
	/**
	 * 
	 * @param email
	 * @return if successfully sent email,
	 *  	or the reason why not in English
	 */
	public EmailAssistanceReponse requestUserNameEmail(EMail email);
}
