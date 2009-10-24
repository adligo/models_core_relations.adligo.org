package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthenticationServiceAsync {
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can save another user
	 * or change the groups (roles are changed by changing the group)
	 * 
	 * @param relations
	 */
	public void saveUser(UserRelations relations, AsyncCallback<SaveResponse> callback);
	
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can do this exc
	 * 
	 * @param relations
	 */
	public void saveGroup(UserGroup group, AsyncCallback<SaveResponse> callback);
	
	/**
	 * try to login
	 * return null if failed
	 */
	public void login(AuthenticationRequest req, AsyncCallback<UserRelations> callback);
	
	/**
	 * a list of domains that the user could log into
	 */
	public void getDomains(AsyncCallback<Collection<String>> callback);
}
