package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.UserGroupMutant;
import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.relations.client.UserRelationsMutant;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordRequest;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordResponse;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthenticationServiceAsync {
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can save another user
	 * or change the groups (roles are changed by changing the group)
	 * 
	 * users should always be able to save their own record at least to change their password
	 * 
	 * @param relations
	 */
	public void saveUser(UserRelationsMutant relations, AsyncCallback<SaveResponse> callback);
	
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can do this exc
	 * 
	 * @param relations
	 * @return
	 */
	//public SaveResponse saveGroup(UserGroupMutant group);
	
	/**
	 * try to login
	 * return null if failed
	 * 
	 * @return
	 */
	//public I_User login(AuthenticationRequest req);
	
	/**
	 * logs the user out of the system
	 * 
	 */
	//public void logout();
	
	/**
	 * the list of domains should come with the config
	 * see the GwtCacheConstants in the gwt_util project
	 */
	
	/**
	 * should send the user a email with a link 
	 * to reset their password
	 * 
	 * takes a AuthenticationRequest so they can also pass their domain if necessary
	 * 
	 * @param req
	 */
	//public void requestForgotPasswordEmail(AuthenticationRequest req);
	
	/**
	 * resets the password for the User associated
	 * with the ResetPasswordRequest's emailToken
	 * also authenticates the user (same as login would have done)
	 * 
	 * @param req
	 * @return
	 */
	//public ResetPasswordResponse resetPassword(ResetPasswordRequest req);

	/**
	 * locate a users based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 * @return
	 */
	//public Collection<UserRelations> findUsers(String params);

	/**
	 * locate user groups based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 * @return
	 */
	//public Collection<UserGroup> findUserGroups(String params);
}

