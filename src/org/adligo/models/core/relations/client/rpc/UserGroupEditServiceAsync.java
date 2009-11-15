package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserGroupEditServiceAsync {

	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can do this exc
	 * 
	 * @param relations
	 */
	public void saveGroup(UserGroup group, AsyncCallback<SaveResponse> callback);
}
