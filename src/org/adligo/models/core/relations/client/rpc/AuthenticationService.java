package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/AuthenticationService")
public interface AuthenticationService extends RemoteService {
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can save another user
	 * or change the groups (roles are changed by changing the group)
	 * 
	 * @param relations
	 * @return
	 */
	public SaveResponse saveUser(UserRelations relations);
	
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can do this exc
	 * 
	 * @param relations
	 * @return
	 */
	public SaveResponse saveGroup(UserGroup group);
	
	/**
	 * try to login
	 * return null if failed
	 * 
	 * @return
	 */
	public UserRelations login(AuthenticationRequest req);
	
	/**
	 * a list of domains that the user could log into
	 * @return
	 */
	public Collection<String> getDomains();
}
