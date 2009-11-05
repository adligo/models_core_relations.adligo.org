package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserRelations;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UserInfoService")
public interface UserInfoService extends RemoteService {
	/**
	 * locate a users based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 * @return
	 */
	public Collection<UserRelations> findUsers(String params);

}
