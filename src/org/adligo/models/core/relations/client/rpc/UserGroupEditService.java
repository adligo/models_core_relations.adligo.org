package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.I_SerializableUserGroup;
import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.rpc.transfer.SaveRequest;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;
import org.adligo.models.core.relations.client.rpc.transfer.SaveUserGroupFailureReasons;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/UserGroupEditService")
public interface UserGroupEditService extends RemoteService {

	/**
	 * the AdiControllerServlet's SecurityChecker should
	 * delegate to figure out if this user can do this exc
	 * 
	 * @param relations
	 * @return
	 */
	public SaveResponse<SaveUserGroupFailureReasons> saveGroups(SaveRequest<I_SerializableUserGroup> group);
}
