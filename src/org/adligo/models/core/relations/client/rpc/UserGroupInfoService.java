package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserGroup;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/UserGroupInfoService")
public interface UserGroupInfoService extends RemoteService {

	/**
	 * locate user groups based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 * @return
	 */
	public Collection<UserGroup> findUserGroups(String params);
}
