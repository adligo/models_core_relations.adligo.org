package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.relations.client.rpc.transfer.SaveRequest;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserEditServiceAsync {
	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can save another user
	 * or change the groups (roles are changed by changing the group)
	 * 
	 * users should always be able to save their own record at least to change their password
	 * change their email exc
	 * 
	 * @param relations
	 */
	public void saveUser(SaveRequest<UserRelations> relations, AsyncCallback<SaveResponse> callback);
}
