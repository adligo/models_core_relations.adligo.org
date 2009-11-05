package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.UserGroupMutant;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

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
	public SaveResponse saveGroup(UserGroupMutant group);
}
