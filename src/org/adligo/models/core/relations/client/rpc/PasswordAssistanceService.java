package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.EmailAssistanceReponse;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordRequest;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordResponse;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/PasswordAssistanceService")
public interface PasswordAssistanceService extends RemoteService {
	/**
	 * should send the user a email with a link 
	 * to reset their password
	 * 
	 * takes a AuthenticationRequest so they can also pass their domain if necessary
	 * 
	 * @param req
	 */
	public EmailAssistanceReponse requestForgotPasswordEmail(AuthenticationRequest req);
	
	/**
	 * resets the password for the User associated
	 * with the ResetPasswordRequest's emailToken
	 * also authenticates the user (same as login would have done)
	 * 
	 * @param req
	 * @return
	 */
	public ResetPasswordResponse resetPassword(ResetPasswordRequest req);
}
