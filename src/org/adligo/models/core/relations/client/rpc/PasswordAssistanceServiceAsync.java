package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordRequest;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PasswordAssistanceServiceAsync {
	/**
	 * should send the user a email with a link 
	 * to reset their password
	 * 
	 * takes a AuthenticationRequest so they can also pass their domain if necessary
	 * 
	 * @param req
	 */
	public void requestForgotPasswordEmail(AuthenticationRequest req, AsyncCallback<Void> callback);
	
	/**
	 * resets the password for the User associated
	 * with the ResetPasswordRequest's emailToken
	 * also authenticates the user (same as login would have done)
	 * 
	 * @param req
	 */
	public void resetPassword(ResetPasswordRequest req, AsyncCallback<ResetPasswordResponse> callback);
}
